package me.camden.ac.events;

import net.b0at.api.event.Event;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MotionEvent extends Event {
    private final Player player;
    private Location from;
    private Location to;
    public MotionEvent(Player player, Location from, Location to) {
        this.player = player;
        this.from = from;
        this.to = to;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

}
