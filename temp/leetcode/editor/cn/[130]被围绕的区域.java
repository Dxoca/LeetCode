class Solution {
//    X X X X
//    X O O X
//    X X O X
//    X # X X
    static int m, n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {//行
            for (int j = 0; j < n; j++) {//列
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                //只扫描边缘的 并改为#
                //因为只需要保留边界的不变 其他的改变就好饿了
                if (board[i][j] == 'O' && isEdge) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] == '#' ? 'O' : 'X');
            }
        }
    }

    /**
     * 搜索包围
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n
                || board[i][j] == 'X' || board[i][j] == '#')//边界 和说明已经搜索过了
            return;
        board[i][j] = '#';//扫描过的 记录
        //上下左右遍历
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
