![Deploy to Sonatype](https://github.com/webfx-project/webfx-platform/actions/workflows/build-and-deploy-to-sonatype.yml/badge.svg)
![Scc Code Count Badge](https://sloc.xyz/github/webfx-project/webfx-platform/?category=code)
![Scc Blanks Count Badge](https://sloc.xyz/github/webfx-project/webfx-platform/?category=blanks)
![Scc Lines Count Badge](https://sloc.xyz/github/webfx-project/webfx-platform/?category=lines)
![Scc Comments Count Badge](https://sloc.xyz/github/webfx-project/webfx-platform/?category=comments)
![Scc COCOMO Badge](https://sloc.xyz/github/webfx-project/webfx-platform/?category=cocomo)
![Discover Vulnerabilities Using CodeQL](https://github.com/webfx-project/webfx-platform/actions/workflows/discover-vulnerabilities.yml/badge.svg)

# The WebFX Platform

The WebFX Platform is the foundation layer & API for cross-platform development with [WebFX](https://github.com/webfx-project/webfx).

<div align="center">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://docs.webfx.dev/webfx-readmes/webfx-platform-dark.svg">
      <img src="https://docs.webfx.dev/webfx-readmes/webfx-platform-light.svg" />
    </picture>

<p></p>

| Modules set        | Location | Description                                                                |
|--------------------|----------|----------------------------------------------------------------------------|
| **UIScheduler**    | Client   | Cross-platform API for scheduling UI tasks (mono thread)                   |
| **Storage**        | Client   | Cross-platform API for client-side storage (LocalStorage & SessionStorage) |
| **WindowHistory**  | Client   | Cross-platform API for accessing the window history                        |
| **WindowLocation** | Client   | Cross-platform API for accessing the window location                       |
| **WebAssembly**    | Client   | Cross-platform API for working with WebAssembly                            |
| **WebWorker**      | Client   | Cross-platform API for working with web workers                            |
| **Resources**      | Shared   | Cross-platform API for accessing resources files                           |
| **Console**        | Shared   | Cross-platform API for logging in the console                              |
| **Boot**           | Shared   | Cross-platform entry point for all WebFX applications                      |
| **Shutdown**       | Shared   | Cross-platform API for shutting down WebFX applications                    |
| **Scheduler**      | Shared   | Cross-platform API for scheduling non-UI tasks                             |
| **Json**           | Shared   | Cross-platform Json API                                                    |
| **Async**          | Shared   | Future & Promise API for async operations                                  |
| **File**           | Shared   | Cross-platform API for accessing local files                               |
| **Vert.x** *       | Server   | Implementation of the server-side modules for [Vert.x](https://vertx.io)   |

*\* An additional implementation for Spring Boot might be considered in the future*.

</div>

## Status

All modules are implemented, but still need to be documented (website & Javadoc).

## License

The WebFX Platform is a free, open-source software licensed under the [Apache License 2.0](LICENSE)
