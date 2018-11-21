package com.valpa;

public class Coordinates3D {

    private int z;
    private int y;
    private int x;

    public static Coordinates3D create(int z, int y, int x) {
        return new Coordinates3D(z, y, x);
    }

    public Coordinates3D(int z, int y, int x) {
        this.z = z;
        this.y = y;
        this.x = x;
    }

    public int getZ() {
        return z;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "{ Z = "+z+", Y = "+y+", X = "+x+" }";
    }

}
