package de.lara.labycubeapi;

import de.lara.labycubeapi.events.LabymodUserJoinEvent;
import de.lara.labycubeapi.utils.LabymodProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class LabyCubeAPI extends JavaPlugin implements PluginMessageListener {

    @Override
    public void onEnable() {
        getServer().getMessenger().registerIncomingPluginChannel(this, "labymod3:main", this);
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("labymod3:main")) {
            return;
        }

        ByteBuf buf = Unpooled.wrappedBuffer(message);
        String key = LabymodProtocol.readString(buf, Short.MAX_VALUE);
        if(key.equals("INFO")) {
            LabymodUserJoinEvent labymodUserJoinEvent = new LabymodUserJoinEvent(player);
            Bukkit.getPluginManager().callEvent(labymodUserJoinEvent);
        }
    }

}
