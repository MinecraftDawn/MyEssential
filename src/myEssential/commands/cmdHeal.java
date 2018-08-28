package myEssential.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdHeal implements ICommand {
    @Override
    public boolean run(CommandSender sender, Command command, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player p = (Player) sender;
        p.setHealth(p.getMaxHealth());
        return false;
    }
}
