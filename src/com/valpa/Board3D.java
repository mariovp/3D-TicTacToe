package com.valpa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board3D {

    private int n = 64; // 4*4*4

    private Cell[] cubeArray = new Cell[n];
    private List<Integer> freePositionList = IntStream.rangeClosed(0,n).boxed().collect(Collectors.toList());

    public Board3D() {
        Arrays.fill(cubeArray, Cell.EMPTY);
        setCell(Coordinates3D.create(0,0,0), Cell.CROSS);
        setCell(Coordinates3D.create(0,0,1), Cell.CROSS);
        setCell(Coordinates3D.create(0,1,0), Cell.CROSS);
        setCell(Coordinates3D.create(0,2,0), Cell.CROSS);
        System.out.println(toString());
    }

    public void setCell(Coordinates3D coordinates3D, Cell cell) {
        int z = coordinates3D.getZ();
        int y = coordinates3D.getY();
        int x = coordinates3D.getX();
        int position = (z*16)+(y*4)+x;
        cubeArray[position] = cell;
    }

    public Cell getCubeCell(int position) {
        return cubeArray[position];
    }

    public List<Integer> getFreePositionList() {
        return freePositionList;
    }

    private void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\tZ=0\t\t\t\tZ=1\t\t\t\tZ=2\t\t\t\tZ=3\n");

        for (int y = 0; y < 4; y++) {
            for (int z = 0; z < 4; z++) {
                for (int x = 0; x < 4; x++) {
                    int position = (z*16)+(y*4)+x;
                    Cell cell = cubeArray[position];
                    stringBuilder.append(cell.toString());
                }
                stringBuilder.append("\t");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
