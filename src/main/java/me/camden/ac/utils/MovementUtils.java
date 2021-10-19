package me.camden.ac.utils;

import me.camden.ac.events.MotionEvent;
import org.bukkit.Location;

import java.util.ArrayList;

public class MovementUtils {

    public static void cancelMovement(MotionEvent event) {
        final Location closest = LocationUtils.getClosestBlockBelow(event.getPlayer(), event.getFrom());
        if (closest != null) {
            closest.add(0.0, 1, 0.0);
            closest.setDirection(event.getFrom().getDirection());
            event.setTo(closest);
            event.getPlayer().teleport(closest);
            event.setCancelled(true);
        }
    }

    public static double getMedian(ArrayList<Double> arrayList) {
        double ret = 0.D;
        for (double d : arrayList) {
            ret += d;
        }
        ret /= arrayList.size();

        return ret;
    }
}
