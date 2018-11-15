package com.valpa;

import java.util.Arrays;

public class Board3D {

    private CellStatus[][][] cubeMatrix = new CellStatus[4][4][4];

    public void init() {

        for (CellStatus[][] matrix2d : cubeMatrix) {
            for (CellStatus[] array : matrix2d) {
                Arrays.fill(array, CellStatus.EMPTY);
            }
        }

        cubeMatrix[0][1][2] = CellStatus.CROSS;
        cubeMatrix[0][1][1] = CellStatus.CIRCLE;

        print();
    }

    private void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        for (CellStatus[][] matrix2d : cubeMatrix) {
            stringBuilder.append("\tCapa ").append(index++).append("\n");
            for (CellStatus[] array : matrix2d) {
                for (CellStatus cellStatus : array) {
                    stringBuilder.append(cellStatus.toString());
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
