# The WebFX Platform

The WebFX Platform is the foundation layer & API for cross-platform development with [WebFX](https://github.com/webfx-project/webfx).

<div align="center">
  <img src="https://docs.webfx.dev/webfx-platform/webfx-platform.svg" />

<p></p>

| Modules set        | Location | Description                                                                |
|--------------------|----------|----------------------------------------------------------------------------|
| **UIScheduler**    | Client   | Cross-platform API for scheduling UI tasks (mono thread)                   |
| **Storage**        | Client   | Cross-platform API for client-side storage (LocalStorage & SessionStorage) |
| **WindowLocation** | Client   | Cross-platform API for accessing the window location                       |
| **WindowHistory**  | Client   | Cross-platform API for accessing the window history                        |
| **WebAssembly**    | Client   | Cross-platform API for working with WebAssembly                            |
| **WebWorker**      | Client   | Cross-platform API for working with web workers                            |
| **Boot**           | Shared   | Cross-platform entry point for all WebFX applications                      |
| **Console**        | Shared   | Cross-platform API for logging in the console                              |
| **Resources**      | Shared   | Cross-platform API for accessing resources files                           |
| **Scheduler**      | Shared   | Cross-platform API for scheduling non-UI tasks                             |
| **Shutdown**       | Shared   | Cross-platform API for shutting down WebFX applications                    |
| **Json**           | Shared   | Cross-platform Json API                                                    |
| **Vert.x** *       | Server   | Implementation of the server-side modules for [Vert.x](https://vertx.io)   |

*\* An additional implementation for Spring Boot might be considered in the future*.

</div>

## Status

All modules are implemented, but still need to be documented (website & Javadoc).

## License

The WebFX Platform is a free, open-source software licensed under the [Apache License 2.0](LICENSE)
