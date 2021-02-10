// 解题思路：DFS
// 时间复杂度：O(N) N 为数组的行数*列数
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        for (int col = 0; col < grid.length; col++) {
            for (int row =0; row < grid[0].length; row++) {
                if(grid[col][row] == '1') {
                    count++;
                    dfs(grid, col, row);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int col, int row) {
        if (validate(grid, col, row)) return;
        // 将访问过的岛屿标记出来
        grid[col][row] = '2';
        dfs(grid, col - 1, row);
        dfs(grid, col + 1, row);
        dfs(grid, col, row + 1);
        dfs(grid, col, row - 1);
    }

    public boolean validate(char[][] grid, int col, int row) {
        if (col < 0 || row < 0 || col >= grid.length || row >= grid[0].length ||
                grid[col][row] == '0' || grid[col][row] == '2') {
            return true;
        }
        return false;
    }
}