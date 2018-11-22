package com.valpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board3D {

    private int n = 64; // 4*4*4

    private Symbol[] cubeArray;
    private List<Integer> freePositionList;

    public static Board3D createBoardWithMove(Board3D board3D, int position, Symbol symbol) {
        Board3D newBoard = new Board3D(board3D.cubeArray, board3D.freePositionList);
        newBoard.setCell(position, symbol);
        return newBoard;
    }

    public Board3D(Symbol[] cubeArray, List<Integer> freePositionList) {
        this.cubeArray = cubeArray;
        this.freePositionList = new ArrayList<>(freePositionList);
    }

    public Board3D() {
        cubeArray = new Symbol[n];
        freePositionList = IntStream.rangeClosed(0, n-1).boxed().collect(Collectors.toList());

        Arrays.fill(cubeArray, Symbol.EMPTY);
        setCell(Coordinates3D.create(0, 0, 0), Symbol.CROSS);
        setCell(Coordinates3D.create(1, 0, 0), Symbol.CROSS);
        setCell(Coordinates3D.create(2, 0, 0), Symbol.CROSS);
        setCell(Coordinates3D.create(0, 2, 0), Symbol.CROSS);
        setCell(Coordinates3D.create(0, 1, 1), Symbol.CIRCLE);
        System.out.println(toString());
    }

    public void setCell(Coordinates3D coordinates3D, Symbol symbol) {
        int z = coordinates3D.getZ();
        int y = coordinates3D.getY();
        int x = coordinates3D.getX();
        int position = (z * 16) + (y * 4) + x;
        setCell(position, symbol);
    }

    public void setCell(int position, Symbol symbol) {
        cubeArray[position] = symbol;
        freePositionList.remove((Integer)position);
    }

    public Symbol getCubeCell(int position) {
        return cubeArray[position];
    }

    public List<Integer> getFreePositionList() {
        return freePositionList.stream().filter(Objects::nonNull).collect(Collectors.toList());
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

                    int position = (z * 16) + (y * 4) + x;
                    Symbol symbol = cubeArray[position];
                    stringBuilder.append(symbol.toString());

                }
                stringBuilder.append("\t");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
