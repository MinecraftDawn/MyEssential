package myEssential.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

public class cmdTeleport implements ICommand {
    @Override
    public boolean run(CommandSender sender, Command command, String[] args) {
        if (!(sender instanceof Player)) return true;

        if (args.length < 1) return true;

        Player p = (Player) sender;

        if (args.length == 1) {

            Player traget = Bukkit.getPlayerExact(args[0]);

            if (traget == null) return true;

            Location loc = traget.getLocation();

            p.teleport(loc);

            return true;
        }

        if (args.length == 3) {
            Double[] loc = new Double[3];

            for (int i = 0; i < 3; i++) {
                if (!isDouble(args[i])) return true;

                loc[i] = Double.parseDouble(args[i]);
            }

            p.teleport(new Location(p.getWorld(), loc[0], loc[1], loc[2]));
            return true;

        }

        return true;
    }

    Boolean isDouble(String s) {
        Pattern patten = Pattern.compile("^([+-]?\\d+)(\\.\\d+)?$");
        return patten.matcher(s).matches();
    }
}
