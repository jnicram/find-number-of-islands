package com.jnicram.islands;

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
                    dfs(map, x, y, visited);
                    ++result;
                }
            }
        }
        return result;
    }

    private boolean canCellBeIncluded(int[][] map, int row, int col, boolean visited[][]) {
        final int xLength = map.length;
        final int yLength = map[0].length;

        return (row >= 0) && (row < xLength) && (col >= 0) && (col < yLength) && (map[row][col] == 1 && !visited[row][col]);
    }

    private void dfs(int[][] map, int row, int col, boolean visited[][]) {
        visited[row][col] = true;

        for (int k = 0; k < 8; ++k) {
            if (canCellBeIncluded(map, row + ROW_NEIGHBORS[k], col + COL_NEIGHBORS[k], visited))
                dfs(map, row + ROW_NEIGHBORS[k], col + COL_NEIGHBORS[k], visited);
        }
    }
}
