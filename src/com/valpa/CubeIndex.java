package com.valpa;

import java.util.HashMap;

public class CubeIndex {

    private HashMap<Integer, Coordinates3D> positionToCoordinates3DMap = new HashMap<>();

    private int squareSide = 4;
    private int layerCubeCount = squareSide*squareSide;

    public Coordinates3D getCoordinates3DFromPosition(int position) {

        if (!positionToCoordinates3DMap.containsKey(position)) {
            int z = position / layerCubeCount;
            int y = (position - (z * layerCubeCount) ) / squareSide;
            int x = position % squareSide;

            var coordinates3D = new Coordinates3D(z, y, x);
            positionToCoordinates3DMap.put(position, coordinates3D);
        }

        Coordinates3D coordinates3D = positionToCoordinates3DMap.get(position);
        System.out.println("Position = "+position);
        System.out.println("Coordinates = "+coordinates3D);

        return coordinates3D;
    }

}
