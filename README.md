# ServerEmitter

A Minecraft plugin that sends test events using [ServerPusher](https://github.com/CappyTech/ServerPusher).

Used to verify that the [ServerPusher](https://github.com/CappyTech/ServerPusher) → [ServerReceiver](https://github.com/CappyTech/ServerReceiver) → MongoDB pipeline is working correctly. Includes a `/pushhello` command for basic testing.

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

```
Copyright 2025 CappyTech (https://github.com/CappyTech/)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

```
