// 解题思路：DFS
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || click.length < 2) return board;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(board, click[0], click[1]);
        }
        return board;
    }

    public void dfs(char[][] board, int col, int row) {
        int count = 0;
        // 计算目标周围的雷数量
        for (int i = col - 1; i <= col + 1; i++) {
            for (int j = row - 1; j <= row + 1; j++) {
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) continue;
                if (board[i][j] == 'M') ++count;
            }
        }
        if (count > 0) {
            board[col][row] = (char) (count + '0');;
        } else {
            board[col][row] = 'B';
            for (int i = col - 1; i <= col + 1; i++) {
                for (int j = row - 1; j <= row + 1; j++) {
                    if (i < 0 || j < 0 || i >= board.length ||
                            j >= board[0].length || board[i][j] != 'E') continue;
                    dfs(board, i, j);
                }
            }
        }
    }
}