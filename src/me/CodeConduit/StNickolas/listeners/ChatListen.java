package me.CodeConduit.StNickolas.listeners;

import me.CodeConduit.StNickolas.Main;
import me.CodeConduit.StNickolas.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListen implements Listener {
    //Variables
    private Main plugin;

    //Constructor
    public ChatListen(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    //EventHandler
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        Bukkit.broadcastMessage(Utils.chat("[&b&lDefault Rank&r] " + e.getPlayer().getDisplayName() + ": " + e.getMessage()));
    }
}
