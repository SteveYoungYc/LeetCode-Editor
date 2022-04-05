//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 回溯 👍 346 👎 0


package com.yc.leetcode.editor.cn;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        int[][] board;

        public int totalNQueens(int n) {
            board = new int[n][n];
            backtrack(n, 0);
            return res;
        }

        void backtrack(int n, int track) {
            if (track == n) {
                res++;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (board[track][i] != 0)
                    continue;
                track++;
                int offset = 0;
                for (int j = track; j < n; j++) {
                    offset++;
                    if (i - offset >= 0)
                        board[j][i - offset]++;
                    if (i + offset < n)
                        board[j][i + offset]++;
                    board[j][i]++;
                }
                backtrack(n, track);
                offset = 0;
                for (int j = track; j < n; j++) {
                    offset++;
                    if (i - offset >= 0)
                        board[j][i - offset]--;
                    if (i + offset < n)
                        board[j][i + offset]--;
                    board[j][i]--;
                }
                track--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}