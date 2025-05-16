# ServerEmitter
-------------

A Minecraft plugin that sends test events using [ServerPusher](https://github.com/CappyTech/ServerPusher).

Used to verify that the [ServerPusher](https://github.com/CappyTech/ServerPusher) → [ServerReceiver](https://github.com/CappyTech/ServerReceiver) → MongoDB pipeline is working correctly. Includes a /pushhello command for basic testing.

## Features:
- Requires ServerPusher plugin.
- Sends to /api/push endpoint.
- Configurable backend URL and token.
- Includes /pushhello command for testing.

## Setup:
1. Place both ServerEmitter.jar and ServerPusher.jar in your minecraft server `/plugins` folder.
2. Edit config.yml with backend URL and Authorization.
3. Run /pushhello to test the pipeline.

## plugin.yml:
```java
depend: [ServerPusher]

commands:
  pushhello:
    description: Send test data
    usage: /pushhello
```
## License:
MIT
