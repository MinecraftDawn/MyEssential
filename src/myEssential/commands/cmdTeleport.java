package myEssential.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
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

        if (args.length == 2) {
            try {
                URL ip = new URL("http://checkip.amazonaws.com");
                BufferedReader in = new BufferedReader(new InputStreamReader(ip.openStream()));
                String s = in.readLine();
                Bukkit.broadcastMessage(s.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        if (args.length == 4) {

        }


        return true;
    }

    Boolean isDouble(String s) {
        Pattern patten = Pattern.compile("^([+-]?\\d+)(\\.\\d+)?$");
        return patten.matcher(s).matches();
    }
}
