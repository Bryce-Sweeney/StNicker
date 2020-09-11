package me.CodeConduit.StNickolas.listeners;

import me.CodeConduit.StNickolas.Main;
import me.CodeConduit.StNickolas.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
        Player player  = (Player) e.getPlayer();
        String rank = (String) plugin.getPlayerDataConfig().get(player.getUniqueId() + ".rank");
        String rankColor = (String) plugin.getPlayerDataConfig().get(player.getUniqueId() + ".rankColor");
        Bukkit.broadcastMessage(Utils.chat("[" + rankColor + "&l" + rank + "&r] " + e.getPlayer().getDisplayName() + ": " + e.getMessage()));
    }
}
