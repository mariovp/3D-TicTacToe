package com.valpa;

public class WinningFlatCoordinates {

    public void init() {

        int[][] flatCoordinates = new int[76][];

        /* Generar combinaciones ganadoras en una sola capa que se encuentran en una misma capa*/

        // Contador de combinaciones
        int count = 0;
        // Recorrer las 4 capas (40 combinaciones)
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

        /* Generar combionaciones entre capas */

        // Combinaciones de fondo (16 combinaciones)
        for (int i = 0; i < 16; i++) {
            flatCoordinates[count++] = new int[] {
                    i,
                    16+i,
                    32+i,
                    48+i};
        }

        // Diagonales entre capas (8 combinaciones)
        for (int i = 0; i < 4; i++) {

            int offset = i*4;

            flatCoordinates[count++] = new int[]{
                    offset,
                    17+offset,
                    34+offset,
                    51+offset};

            flatCoordinates[count++] = new int[]{
                    3+offset,
                    18+offset,
                    33+offset,
                    48+offset};

            flatCoordinates[count++] = new int[]{
                    offset,
                    20+ offset,
                    40+ offset,
                    60+ offset};

            flatCoordinates[count++] = new int[]{
                    12+offset,
                    24+ offset,
                    36+ offset,
                    48+ offset};
        }

        // Diagonales entre esquinas del cubo (4 combinaciones)
        flatCoordinates[count++] = new int[] {
                0,
                21,
                42,
                63};

        flatCoordinates[count++] = new int[] {
                12,
                25,
                38,
                51};

        flatCoordinates[count++] = new int[] {
                3,
                22,
                41,
                60};

        flatCoordinates[count++] = new int[] {
                15,
                26,
                37,
                48};

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
