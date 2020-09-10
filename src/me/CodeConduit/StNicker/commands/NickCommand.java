package me.CodeConduit.StNicker.commands;

import me.CodeConduit.StNicker.Main;
import me.CodeConduit.StNicker.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {
    //Variables
    private Main plugin;

    //Standard executor for commands
    public NickCommand(Main plugin) {
        this.plugin = plugin;

        plugin.getCommand("nick").setExecutor(this);
    }

    //CommandExecutor
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("nick.use")) {
            if (args.length == 0) {
                player.setDisplayName(Utils.chat("&k&6eeeeeee"));
            } else if (args.length == 1) {
                player.setDisplayName(Utils.chat(args[0]));
            }
        } else {
            player.sendMessage(Utils.chat("&c[&6Nick&c] You do not have permission to nick yourself!"));
        }
        return true;
    }
}
