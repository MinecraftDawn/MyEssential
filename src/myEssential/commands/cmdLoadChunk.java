package myEssential.commands;

import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdLoadChunk implements ICommand {
    @Override
    public boolean run(CommandSender sender, Command command, String[] args) {
        if(!(sender instanceof Player)) return true;

        if(args.length == 1){
            Player p = (Player) sender;

            Thread t = new Thread(new ChunkLoader(p,Integer.parseInt(args[0])));
            t.setPriority(3);
            t.start();


            Bukkit.broadcastMessage("Done");
        }

        if(args.length == 2) {
            Player p = (Player) sender;

//        Chunk c = p.getWorld().getChunkAt(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
            Location loc = new Location(p.getWorld(), Integer.parseInt(args[0]), 100, Integer.parseInt(args[1]));
            Chunk c = p.getWorld().getChunkAt(loc);

            c.load(true);
            Bukkit.broadcastMessage("加載世界");

        }

        if(args.length == 3){
            Player p = (Player) sender;
            Location loc = new Location(p.getWorld(), Integer.parseInt(args[0]), 100, Integer.parseInt(args[1]));
            Chunk c = p.getWorld().getChunkAt(loc);

            if(c.isLoaded()){
                p.sendMessage("Load");
            }else{
                p.sendMessage("沒有讀取唷");
            }

        }

        if(args.length == 4){
            Player p = (Player) sender;

            Location loc = new Location(p.getWorld(), Integer.parseInt(args[0]), 100, Integer.parseInt(args[1]));
            Chunk c = p.getWorld().getChunkAt(loc);

            if(c.isLoaded()){
                p.sendMessage("Load");
            }else{
                p.sendMessage("沒有讀取唷");
            }

            c.unload(true);

            if(c.isLoaded()){
                p.sendMessage("Load");
            }else{
                p.sendMessage("沒有讀取唷");
            }

        }


        return true;
    }

}
