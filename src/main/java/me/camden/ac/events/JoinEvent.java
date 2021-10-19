package me.camden.ac.events;

import net.b0at.api.event.Event;
import org.bukkit.entity.Player;

public class JoinEvent extends Event {
    private final Player player;

    public JoinEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
