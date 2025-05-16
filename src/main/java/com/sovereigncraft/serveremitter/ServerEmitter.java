package com.sovereigncraft.serveremitter;

import com.sovereigncraft.serverpusher.ServerPusher;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ServerEmitter extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Configure ServerPusher using values from config.yml
        String backendUrl = getConfig().getString("backend-url");
        String authHeaderKey = getConfig().getString("auth-header", "Authorization");
        String authToken = getConfig().getString("auth-token");

        Map<String, String> headers = new HashMap<>();
        headers.put(authHeaderKey, authToken);

        ServerPusher.configure(backendUrl, headers, getLogger());
        getCommand("pushhello").setExecutor(new PushHelloCommand(getLogger()));
        getLogger().info("ServerEmitter is active and ready to emit!");
    }

    public static class PushHelloCommand implements CommandExecutor {
        private final Logger logger;

        public PushHelloCommand(Logger logger) {
            this.logger = logger;
        }

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Map<String, Object> payload = new HashMap<>();
            payload.put("server_id", "us");
            payload.put("message", "Hello from ServerEmitter!");
            payload.put("event", "hello_test");
            payload.put("timestamp", Instant.now().toString());

            boolean success = ServerPusher.sendData("hello_test", payload);
            if (success) {
                sender.sendMessage("§a✅ Hello payload sent successfully!");
                logger.info("Hello payload sent by ServerEmitter.");
            } else {
                sender.sendMessage("§c❌ Failed to send Hello payload.");
                logger.warning("Failed to send Hello payload from ServerEmitter.");
            }
            return true;
        }
    }
} 
