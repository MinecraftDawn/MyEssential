package myEssential.commands;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdMusic implements ICommand {
    @Override
    public boolean run(CommandSender sender, Command command, String[] args) {
        if(args.length == 0){
            for(Player p :Bukkit.getOnlinePlayers()){
                String sound = "piano.piano050";
                p.playSound(p.getLocation(),sound,SoundCategory.MASTER,1,1);
            }
            return true;
        }

        if (!(sender instanceof Player)) return true;

        if(args[1].equals("build")) {
            Player p = (Player) sender;
            World world = p.getWorld();
            for (int i = 0; i < 88; i++) {
                Location loc1 = p.getLocation().add(new Location(world, 0, 0, i));

                Block b1 = world.getBlockAt(loc1);
                b1.setType(Material.COMMAND);
                b1.setData((byte) 5);

                CommandBlock cmd1 = (CommandBlock) b1.getState();
                cmd1.setCommand("fill ~ ~1 ~ ~ ~3 ~ minecraft:air 0 replace");

                cmd1.update();

                Location loc2 = p.getLocation().add(new Location(world, 1, 0, i));

                Block b2 = world.getBlockAt(loc2);
                b2.setType(Material.COMMAND_CHAIN);
                b2.setData((byte) 5);

                CommandBlock cmd2 = (CommandBlock) b2.getState();
                if (i + 21 < 100)
                    cmd2.setCommand("execute @a ~ ~ ~ playsound " + "piano.piano0" + (i + 21) + " master @p ~ ~ ~ 1 1");
                else
                    cmd2.setCommand("execute @a ~ ~ ~ playsound " + "piano.piano" + (i + 21) + " master @p ~ ~ ~ 1 1");
                cmd2.update();
            }
            return true;

        }
        return true;
    }
}
