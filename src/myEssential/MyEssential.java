package myEssential;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import myEssential.commands.cmdManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class MyEssential extends JavaPlugin implements Listener {

    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("tp").setExecutor((CommandExecutor) new cmdManager());

        Bukkit.getPluginManager().registerEvents(this,this);

        protocolManager = ProtocolLibrary.getProtocolManager();

//        protocolManager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Server.TAB_COMPLETE) {
//            @Override
//            public void onPacketSending(PacketEvent e) {
//                if (e.getPacketType() == PacketType.Play.Server.TAB_COMPLETE) {
//                    e.setCancelled(true);
//                }
//            }
//        });
    }

    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent e){

//        e.setCancelled(true);
    }

}
