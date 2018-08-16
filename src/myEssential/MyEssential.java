package myEssential;

import myEssential.commands.cmdManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class MyEssential extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("tp").setExecutor((CommandExecutor) new cmdManager());
    }
}
