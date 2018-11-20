package com.valpa;

public class WinningPositions {

    private int[][] winningPositionsArray = new int[76][];

    @SuppressWarnings("UnnecessaryLocalVariable")
    public WinningPositions() {
        /* Generar combinaciones ganadoras en una sola capa que se encuentran en una misma capa*/

        // Contador de combinaciones
        int count = 0;
        // Recorrer las 4 capas (40 combinaciones)
        for (int layer = 0; layer < 4; layer++) {

            int layerOffset = 16 * layer;

            // Generar 4 combinaciones de filas y 4 combinaciones de columnas ganadoras
            for (int n = 0; n < 4; n++) {
                int rowOffset = 4 * n;
                int columnOffset = n;

                // Lineas horizontales
                winningPositionsArray[count++] = new int[]{
                        layerOffset + rowOffset,
                        1 + layerOffset + rowOffset,
                        2 + layerOffset + rowOffset,
                        3 + layerOffset + rowOffset};

                // Lineas verticales
                winningPositionsArray[count++] = new int[]{
                        layerOffset + columnOffset,
                        4 + layerOffset + columnOffset,
                        8 + layerOffset + columnOffset,
                        12 + layerOffset + columnOffset};
            }

            // Generar las 2 diagonales de cada capa
            winningPositionsArray[count++] = new int[]{
                    layerOffset,
                    5 + layerOffset,
                    10 + layerOffset,
                    15 + layerOffset};

            winningPositionsArray[count++] = new int[]{
                    12 + layerOffset,
                    9 + layerOffset,
                    6 + layerOffset,
                    3 + layerOffset};
        }

        /* Generar combionaciones entre capas */

        // Combinaciones de fondo (16 combinaciones)
        for (int i = 0; i < 16; i++) {
            winningPositionsArray[count++] = new int[]{
                    i,
                    16 + i,
                    32 + i,
                    48 + i};
        }

        // Diagonales entre capas (8 combinaciones)
        for (int n = 0; n < 4; n++) {

            int rowOffset = n * 4;
            int columnOffset = n;

            // Diagonales horizontales  entre capas
            winningPositionsArray[count++] = new int[]{
                    rowOffset,
                    17 + rowOffset,
                    34 + rowOffset,
                    51 + rowOffset};

            winningPositionsArray[count++] = new int[]{
                    3 + rowOffset,
                    18 + rowOffset,
                    33 + rowOffset,
                    48 + rowOffset};

            // Diagonales verticales  entre capas
            winningPositionsArray[count++] = new int[]{
                    columnOffset,
                    20 + columnOffset,
                    40 + columnOffset,
                    60 + columnOffset};

            winningPositionsArray[count++] = new int[]{
                    12 + columnOffset,
                    24 + columnOffset,
                    36 + columnOffset,
                    48 + columnOffset};
        }

        // Diagonales entre esquinas del cubo (4 combinaciones)
        winningPositionsArray[count++] = new int[]{
                0,
                21,
                42,
                63};

        winningPositionsArray[count++] = new int[]{
                12,
                25,
                38,
                51};

        winningPositionsArray[count++] = new int[]{
                3,
                22,
                41,
                60};

        winningPositionsArray[count++] = new int[]{
                15,
                26,
                37,
                48};

        int index = 0;
        for (int[] ints : winningPositionsArray) {
            System.out.println("("+(index++)+")"+" { "+ints[0]+", "+ints[1]+", "+ints[2]+", "+ints[3]+" }");
        }

        //System.out.println(winningPositionsArray);
    }

    public int[][] getWinningPositionsArray() {
        return winningPositionsArray;
    }
}
