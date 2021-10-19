package me.camden.ac.events;

import net.b0at.api.event.Event;
import org.bukkit.entity.Player;

public class DisconnectEvent extends Event {
    private final Player player;

    public DisconnectEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
