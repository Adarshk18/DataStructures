import java.util.*;

public class DistinctIslands {

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<String> st = new HashSet<>();
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, vis, i, j, i, j, shape);
                    shape.add(String.join(",", shape));
                }
            }
        }
        return st.size();

    }

    private static void dfs(char[][] grid, boolean[][] vis, int row, int col, int baseRow, int baseCol, List<String> shape) {
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || col < 0 || row >= n || col >= m || vis[row][col] || grid[row][col] == '1') {
            return;
        }

        vis[row][col] = true;
        shape.add((row - baseRow) + "_" + (col - baseCol));
        dfs(grid, vis, row + 1, col, baseRow, baseCol, shape);
        dfs(grid, vis, row - 1, col, baseRow, baseCol, shape);
        dfs(grid, vis, row, col + 1, baseRow, baseCol, shape);
        dfs(grid, vis, row, col - 1, baseRow, baseCol, shape);
    }

    public static void main(String[] args) {

    }
}
