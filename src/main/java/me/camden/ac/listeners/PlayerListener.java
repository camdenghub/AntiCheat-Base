package me.camden.ac.listeners;

import me.camden.ac.AntiCheatPlugin;
import me.camden.ac.events.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class PlayerListener implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("anticheat.perms"))
            return;

        final JoinEvent joinEvent = new JoinEvent(event.getPlayer());
        AntiCheatPlugin.getInstance().bus.fireEvent(joinEvent);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDisconnect(PlayerQuitEvent event) {
        if (event.getPlayer().hasPermission("anticheat.perms"))
            return;

        final DisconnectEvent disconnectEvent = new DisconnectEvent(event.getPlayer());
        AntiCheatPlugin.getInstance().bus.fireEvent(disconnectEvent);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(PlayerMoveEvent event) {
        if (event.getPlayer().hasPermission("anticheat.perms"))
            return;

        final MotionEvent motionEvent = new MotionEvent(event.getPlayer(),
                event.getFrom(),
                event.getTo());
        AntiCheatPlugin.getInstance().bus.fireEvent(motionEvent);

        event.setFrom(motionEvent.getFrom());
        event.setTo(motionEvent.getTo());
        event.setCancelled(motionEvent.isCancelled());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onKill(PlayerDeathEvent event) {
        if (event.getEntity().hasPermission("anticheat.perms"))
            return;

        final DeathEvent deathEvent = new DeathEvent(event.getEntity());
        AntiCheatPlugin.getInstance().bus.fireEvent(deathEvent);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event) {
        if (event.getPlayer().hasPermission("anticheat.perms") || event.getItem() == null)
            return;

        final InteractEvent interactEvent = new InteractEvent(event.getPlayer(),
                event.getItem(),
                event.getAction(),
                event.getClickedBlock(),
                event.getBlockFace(),
                event.useInteractedBlock(),
                event.useItemInHand(),
                event.getHand());

        AntiCheatPlugin.getInstance().bus.fireEvent(interactEvent);

        event.setUseInteractedBlock(event.useInteractedBlock());
        event.setUseItemInHand(interactEvent.getUseItemInHand());
        event.setCancelled(interactEvent.isCancelled());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTeleport(PlayerTeleportEvent event) {
        if (event.getPlayer().hasPermission("anticheat.perms"))
            return;

        final TeleportEvent teleportEvent = new TeleportEvent(event.getPlayer(),
                event.getFrom(),
                event.getTo());

        AntiCheatPlugin.getInstance().bus.fireEvent(teleportEvent);

        event.setFrom(teleportEvent.getFrom());
        event.setTo(teleportEvent.getTo());
        event.setCancelled(teleportEvent.isCancelled());
    }
}
