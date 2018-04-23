package com.jnicram.islands;

import java.util.Stack;

public class IslandsCounterImpl implements IslandsCounter {

    private static final int[] ROW_NEIGHBORS = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL_NEIGHBORS = {-1, 0, 1, -1, 1, -1, 0, 1};

    @Override
    public int count(int[][] map) {
        int result = 0;
        if (map.length == 0) return result;

        final int xLength = map.length;
        final int yLength = map[0].length;
        
        boolean visited[][] = new boolean[xLength][yLength];
        for (int x = 0; x < xLength; ++x) {
            for (int y = 0; y < yLength; ++y) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    dfs(map, new Cell(x, y), visited);
                    ++result;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] map, Cell cell, boolean visited[][]) {
        Stack<Cell> stack = new Stack<>();
        stack.push(cell);

        while (!stack.empty()) {
            final Cell pop = stack.pop();
            if (!visited[pop.getRow()][pop.getCol()]) {
                visited[pop.getRow()][pop.getCol()] = true;
                for (int k = 0; k < 8; ++k) {
                    Cell cellToBeVisited = new Cell(pop.getRow() + ROW_NEIGHBORS[k], pop.getCol() + COL_NEIGHBORS[k]);
                    if (canCellBeIncluded(map, cellToBeVisited)) stack.push(cellToBeVisited);
                }
            }
        }
    }

    private boolean canCellBeIncluded(int[][] map, Cell cell) {
        final int xLength = map.length;
        final int yLength = map[0].length;

        return cell.getRow() >= 0 && cell.getRow() < xLength && cell.getCol() >= 0 && cell.getCol() < yLength
                && map[cell.getRow()][cell.getCol()] == 1;
    }
}
