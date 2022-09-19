package de.lara.labycubeapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LabymodUserJoinEvent extends Event {


    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public LabymodUserJoinEvent(Player player) {
        this.player = player;
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return player;
    }
}
