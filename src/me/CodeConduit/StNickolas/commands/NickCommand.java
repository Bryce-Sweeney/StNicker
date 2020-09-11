package me.CodeConduit.StNickolas.commands;

import me.CodeConduit.StNickolas.Main;
import me.CodeConduit.StNickolas.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {
    //Variables
    private Main plugin;
    public static String[] defaultNicknames = {"ImNotNicked", "2cool4nick", "Poggens", "Hubooker", "Gameplavi", "Santu", "Superid", "Kinois", "derp"};

    //Standard executor for commands
    public NickCommand(Main plugin) {
        this.plugin = plugin;

        plugin.getCommand("nick").setExecutor(this);
    }

    //CommandExecutor
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        String randomNick = defaultNicknames[(int) ((defaultNicknames.length - 1)*Math.random())];
        if (player.hasPermission("nick.use")) {
            if (args.length == 0) {
                if (Math.random() <= 0.5) {
                    player.setDisplayName(Utils.chat(randomNick));
                    player.sendMessage(Utils.chat("&6[&aNick&6] Your display name has been set to&a " + randomNick + "&6!"));
                } else {
                    player.setDisplayName(Utils.chat(randomNick + "YT"));
                    player.sendMessage(Utils.chat("&6[&aNick&6] Your display name has been set to&a " + randomNick + "YT&6!"));
                }
            } else {
                player.setDisplayName(Utils.chat(args[0]));
                player.sendMessage(Utils.chat("&6[&aNick&6] Your display name has been set to&a " + args[0] + "&6!"));
            }
        } else {
            player.sendMessage(Utils.chat("&c[Nick] You do not have permission to nick yourself!"));
        }
        return true;
    }
}
