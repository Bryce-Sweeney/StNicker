package me.CodeConduit.StNicker;

import me.CodeConduit.StNicker.commands.NickCommand;
import me.CodeConduit.StNicker.listeners.ChatListen;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable() {
        new NickCommand(this);
        new ChatListen(this);
    }
}
