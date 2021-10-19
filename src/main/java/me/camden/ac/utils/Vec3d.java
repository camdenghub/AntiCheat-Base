package me.camden.ac.utils;

import org.bukkit.Location;

public class Vec3d {
    private double x,y,z;

    public Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3d(Location location1, Location location2) {
        this.x = location1.getX() - location2.getX();
        this.y = location1.getY() - location2.getY();
        this.z = location1.getZ() - location2.getZ();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
