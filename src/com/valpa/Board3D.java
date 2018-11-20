package com.valpa;

import java.util.Arrays;

public class Board3D {

    private CubeCell[][][] cubeMatrix = new CubeCell[4][4][4];

    public void init() {

        for (CubeCell[][] matrix2d : cubeMatrix) {
            for (CubeCell[] array : matrix2d) {
                Arrays.fill(array, CubeCell.EMPTY);
            }
        }

        cubeMatrix[0][1][2] = CubeCell.CROSS;
        cubeMatrix[0][1][1] = CubeCell.CIRCLE;

        print();
    }

    private void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        for (CubeCell[][] matrix2d : cubeMatrix) {
            stringBuilder.append("\tCapa ").append(index++).append("\n");
            for (CubeCell[] array : matrix2d) {
                for (CubeCell cubeCellStatus : array) {
                    stringBuilder.append(cubeCellStatus.toString());
                }
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
