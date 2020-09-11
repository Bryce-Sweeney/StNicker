package me.CodeConduit.StNickolas.commands;

import me.CodeConduit.StNickolas.Main;
import me.CodeConduit.StNickolas.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnNickCommand implements CommandExecutor {
    //Variables
    private Main plugin;

    //Standard executor for commands
    public UnNickCommand(Main plugin) {
        this.plugin = plugin;

        plugin.getCommand("nick").setExecutor(this);
    }

    //CommandExecutor
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;

        player.setDisplayName(player.getName());

        return true;
    }
}
