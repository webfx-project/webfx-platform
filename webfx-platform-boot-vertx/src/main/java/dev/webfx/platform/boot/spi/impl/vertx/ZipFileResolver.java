package dev.webfx.platform.boot.spi.impl.vertx;

import io.vertx.core.file.impl.FileResolverImpl;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.spi.file.FileResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class ZipFileResolver implements FileResolver {

    // Keeping zip archives open for better performance, but this behaviour can be turned off below.
    private static final boolean KEEP_ZIP_ARCHIVES_OPEN = true;
    private static final boolean REMEMBER_EXTRACTED_FILES = true;

    // Logger to report issues with zip operations
    private static final Logger LOGGER = LoggerFactory.getLogger(ZipFileResolver.class);

    // The default file resolver that will be used for files not located in zip archives
    private final FileResolver nonZipFileResolver;

    // When keeping zip archives open, this map memorize the zip file system (still open) associated to each archive path
    private final Map<String, FileSystem> openZipFileSystems = new HashMap<>();
    private final Map<String, Long> zipDates = new HashMap<>();

    private final Map<Path /* zipFsEntryPath */, File> extractedFiles = new HashMap<>();

    public ZipFileResolver() {
        this(new FileResolverImpl());
    }

    public ZipFileResolver(FileResolver nonZipFileResolver) {
        this.nonZipFileResolver = nonZipFileResolver;
    }

    @Override
    public File resolveFile(String fileName) {
        // The expected syntax is an exclamation point at the end of the .zip file (or .jar, .war, etc..).
        // Ex: /path-to-webapp/webapp.war!/root-folder/index.html
        int exclamationIndex = fileName.indexOf("!");
        // If not found, we pass the request to the non zip file resolver
        if (exclamationIndex == -1)
            return nonZipFileResolver.resolveFile(fileName);
        // Extracting the path to the archive (ex: /path-to-webapp/webapp.war)
        String archivePath = fileName.substring(0, exclamationIndex);
        // Looking for an existing zip file system associated to that path
        FileSystem zipFs = openZipFileSystems.get(archivePath);
        if (zipFs == null) { // If not, we create it
            try {
                // Note: this call to FileSystems.newFileSystem() requires Java >= 13
                Path zipPath = Path.of(archivePath);
                zipFs = FileSystems.newFileSystem(zipPath);
                // We memorize that file system in the map
                openZipFileSystems.put(archivePath, zipFs);
                zipDates.put(archivePath, zipPath.toFile().lastModified());
            } catch (IOException e) {
                LOGGER.warn("Unable to open zip archive " + archivePath, e);
                return new File(fileName); // returning a non-null but non-existing file
            }
        }
        // The zip entry is the part specified after the exclamation point
        String zipEntry = fileName.substring(exclamationIndex + 1);
        // We transform it to a path for the zip file system
        Path zipFsEntryPath = zipFs.getPath(zipEntry);
        File tempFile = extractedFiles.get(zipFsEntryPath);
        if (tempFile != null)
            return tempFile;
        try {
            // Copying the zip entry to a temporary file that will finally be served
            Path tempPath = Files.createTempFile(null, null);
            Files.copy(zipFsEntryPath, tempPath, StandardCopyOption.REPLACE_EXISTING);
            // We need to return a file instance of that temporary file
            tempFile = tempPath.toFile();
            // Setting last modified on the extracted file, as this is the value Vert.x will report to the browser
            Long zipDate = zipDates.get(archivePath);
            if (zipDate != null)
                tempFile.setLastModified(zipDate);
            // We mark that file to be deleted on server exit
            tempFile.deleteOnExit();
            if (REMEMBER_EXTRACTED_FILES)
                extractedFiles.put(zipFsEntryPath, tempFile);
            // Closing the zip file system
            if (!KEEP_ZIP_ARCHIVES_OPEN) {
                openZipFileSystems.remove(archivePath);
                zipFs.close();
            }
            // Returning the temporary file
            return tempFile;
        } catch (NoSuchFileException e) {
            LOGGER.warn("Unable to find zip entry " + fileName);
            return new File(fileName); // returning a non-null but non-existing file
        } catch (IOException e) {
            LOGGER.warn("Error while trying to extract zip entry " + fileName, e);
            return new File(fileName); // returning a non-null but non-existing file
        }
    }

    @Override
    public void close() throws IOException {
        // Closing all open zip file systems
        for (Iterator<FileSystem> it = openZipFileSystems.values().iterator(); it.hasNext(); ) {
            it.next().close(); // may raise an exception
            it.remove();
        }
        // Closing the underlying default file resolver
        nonZipFileResolver.close();
    }
}
