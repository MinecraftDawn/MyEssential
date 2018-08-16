package myEssential.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface ICommand {
    public boolean run(CommandSender sender, Command command, String[] args);
}
