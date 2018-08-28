package myEssential.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdFood implements ICommand {
    @Override
    public boolean run(CommandSender sender, Command command, String[] args) {
        Player p = (Player) sender;
        p.setFoodLevel(22);
        return false;
    }
}
