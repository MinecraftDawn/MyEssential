package myEssential.commands;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public class ChunkLoader implements Runnable {
    private Player p;
    private int num;

    public ChunkLoader(Player p,int num){
        this.p = p;
        this.num = num;
    }


    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                Chunk c = p.getWorld().getChunkAt(16*i,16*j);
                c.unload(true);
            }
        }
        Bukkit.broadcastMessage("Done");
    }
}
