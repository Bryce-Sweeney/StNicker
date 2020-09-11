package me.CodeConduit.StNickolas.listeners;

import me.CodeConduit.StNickolas.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class SavePlayer implements Listener {
    //Variables
    private Main plugin;

    //Standard constructor for listeners
    public SavePlayer(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    //Join event
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = (Player) e.getPlayer();
        //If player does not have a playerdata file, then make some defaults
        if (plugin.getPlayerDataConfig().get(String.valueOf(player.getUniqueId())) == null) {
            plugin.getPlayerDataConfig().set(player.getUniqueId() + ".rank", "default");
            plugin.getPlayerDataConfig().set(player.getUniqueId() + ".rankColor", "&b");
        }

        //Save
        try {
            plugin.getPlayerDataConfig().save(plugin.getPlayerDataFile());
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
