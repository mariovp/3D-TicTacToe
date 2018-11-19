package com.valpa;

public class WinningFlatCoordinates {

    public void init() {

        int[][] flatCoordinates = new int[40][];

        /* Generar combinaciones ganadoras en una sola capa que se encuentran en una misma capa*/

        // Contador de combinaciones
        int count = 0;
        // Recorrer las 4 capas
        for (int layer = 0; layer < 4; layer++) {

            int layerOffset = 16*layer;

            // Generar 4 combinaciones de filas y 4 combinaciones de columnas ganadoras
            for (int row = 0; row < 4; row++) {
                int rowOffset = 4*row;
                flatCoordinates[count++] = new int[]{
                        layerOffset+rowOffset,
                        1+layerOffset+rowOffset,
                        2+layerOffset+rowOffset,
                        3+layerOffset+rowOffset};

                flatCoordinates[count++] = new int[]{
                        layerOffset+rowOffset,
                        4+layerOffset+rowOffset,
                        8+layerOffset+rowOffset,
                        12+layerOffset+rowOffset};
            }

            // Generar las 2 diagonales de cada capa
            flatCoordinates[count++] = new int[]{
                    layerOffset,
                    5+layerOffset,
                    10+layerOffset,
                    15+layerOffset};

            flatCoordinates[count++] = new int[]{
                    12+layerOffset,
                    9+layerOffset,
                    6+layerOffset,
                    3+layerOffset};
        }

        System.out.println(flatCoordinates);
        /*for (int[] flatCoordinate : flatCoordinates) {
            System.out.print("{");
            for (int i : flatCoordinate) {
                System.out.print(" "+i+", ");
            }
            System.out.println("}");
        }*/

    }

}
