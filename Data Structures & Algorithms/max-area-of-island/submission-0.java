class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        // grid: 0 = water, 1 = land
        int rows = grid.length;
        int cols = grid[0].length;

        // track visited land cells
        boolean[][] visited = new boolean[rows][cols];

        // store maximum island area
        int maxArea = 0;

        // traverse every cell in grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // if we find unvisited land we explore island
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = dfs(grid, r, c, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }   
    
      private int dfs(int[][] grid, int r, int c, boolean[][] visited) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return 0;
        }

        if (grid[r][c] == 0) return 0;
        if (visited[r][c]) return 0;

        // mark current cell as visited and count it
        visited[r][c] = true;
        int area = 1;

        area += dfs(grid, r + 1, c, visited);
        area += dfs(grid, r - 1, c, visited);
        area += dfs(grid, r, c + 1, visited);
        area += dfs(grid, r, c - 1, visited);

        return area;
    }
}
