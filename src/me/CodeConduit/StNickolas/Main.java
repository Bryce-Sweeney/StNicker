package me.CodeConduit.StNickolas;

import me.CodeConduit.StNickolas.commands.NickCommand;
import me.CodeConduit.StNickolas.listeners.ChatListen;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable() {
        new NickCommand(this);
        new ChatListen(this);
    }
}
