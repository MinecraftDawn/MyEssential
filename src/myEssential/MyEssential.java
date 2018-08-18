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
import org.bukkit.plugin.java.JavaPlugin;

public class MyEssential extends JavaPlugin {

    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("tp").setExecutor((CommandExecutor) new cmdManager());

        protocolManager = ProtocolLibrary.getProtocolManager();

        protocolManager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Server.TAB_COMPLETE) {
            @Override
            public void onPacketSending(PacketEvent e) {
                if (e.getPacketType() == PacketType.Play.Server.TAB_COMPLETE)
                    e.setCancelled(true);
            }
        });
    }

}
