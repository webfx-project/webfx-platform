package emul.java.util;

/**
 * GWT and WebFX don't support Java ResourceBundle, but we declare it here for compatibility purpose with the FXML API,
 * in particular for the Initializable.initialize(URL location, ResourceBundle resources) method. But our FXML
 * implementation always passes resources = null for now.
 *
 * @author Bruno Salmon
 */
public class ResourceBundle { }
