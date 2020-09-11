package me.CodeConduit.StNickolas;

import me.CodeConduit.StNickolas.commands.NickCommand;
import me.CodeConduit.StNickolas.commands.UnNickCommand;
import me.CodeConduit.StNickolas.listeners.ChatListen;
import me.CodeConduit.StNickolas.listeners.SavePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    //Variables
    private File playerdataFile = new File(getDataFolder(), "playerdata.yml");
    private FileConfiguration playerdataConfig = YamlConfiguration.loadConfiguration(playerdataFile);

    //Executes when plugin is enabled
    public void onEnable() {
        if (!playerdataFile.exists()) {
            saveResource("playerdata.yml", false);
        }
        enableCommands(true);
        enableListeners(true);
    }

    //Enables when plugin is disabled
    public void onDisable() {
        try {
            getPlayerDataConfig().save(getPlayerDataFile());
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    //Enables Command Package
    public void enableCommands(boolean enable) {
        if (enable) {
            new NickCommand(this);
            new UnNickCommand(this);
        }
    }

    //Enables Listener Package
    public void enableListeners(boolean enable) {
        if (enable) {
            new ChatListen(this);
            new SavePlayer(this);
        }
    }

    //Getters for playerData
    public FileConfiguration getPlayerDataConfig() {
        return playerdataConfig;
    }
    public File getPlayerDataFile() {
        return playerdataFile;
    }
}
