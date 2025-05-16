# ServerEmitter

A Minecraft plugin that sends test events using [ServerPusher](https://github.com/CappyTech/ServerPusher).

Used to verify that the ServerPusher → [ServerReceiver](https://github.com/CappyTech/ServerReceiver) → MongoDB pipeline is working correctly. Includes a `/pushhello` command for basic testing.

---

## Features

- Sends JSON data to a remote HTTP backend
- Uses ServerPusher for flexible payloads
- Test command: `/pushhello`
- Configurable backend URL and auth via `config.yml`
- Declares dependency on ServerPusher

---

## Requirements

- Java 17+
- Paper/Spigot 1.18 or later
- `ServerPusher.jar` must also be placed in `/plugins`

---

## Setup

1. Place both `ServerEmitter.jar` and `server-pusher-1.0.0.jar` into your server’s `/plugins` folder.
2. Start the server to generate `config.yml`
3. Edit `config.yml`:

```yaml
backend-url: http://localhost:3000/api/push
auth-header: Authorization
auth-token: Bearer your-token-here
```

4. Use `/pushhello` in-game or from the console to send a test payload.

---

## plugin.yml Example

```yaml
depend: [ServerPusher]

commands:
  pushhello:
    description: Sends a hello-world test to the backend
    usage: /pushhello
```

---

## License

MIT
