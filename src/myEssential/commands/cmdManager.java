package myEssential.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class cmdManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (s.equals("tp")) {
            cmdTeleport cmd = new cmdTeleport();
            cmd.run(sender, command, args);

            return true;
        }
        if (s.equals("music")) {
            cmdMusic cmd = new cmdMusic();
            cmd.run(sender, command, args);

            return true;
        }
        return true;
    }
}
