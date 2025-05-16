ServerPusher
------------

Generic JSON transport library for Minecraft plugins.

ServerPusher enables Spigot/Paper plugins to send dynamic JSON payloads via HTTP POST to external services like Node.js backends. It’s lightweight, plugin-agnostic, and ideal for dashboards, monitoring, and analytics.

Features:
- Send structured JSON from Minecraft
- Built-in HTTP client with custom headers
- Add to any plugin without rewriting logic
- Used by ServerEmitter and ServerReceiver

Usage:
- Configure with a backend URL and headers (e.g., Authorization)
- Send any data as Map<String, Object>
- Sends automatically as JSON via POST

Example:
  Map<String, Object> data = new HashMap<>();
  data.put("event", "heartbeat");
  data.put("players", 10);
  ServerPusher.sendData("heartbeat", data);

License:
MIT
