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
        int[][] diagonal;

        public int totalNQueens(int n) {
            diagonal = new int[n][n];
            boolean[] used = new boolean[n];
            backtrack(n, 0, used);
            return res;
        }

        void backtrack(int n, int track, boolean[] used) {
            if (track == n) {
                res++;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (used[i] || diagonal[track][i] != 0)
                    continue;
                track++;
                int offset = 0;
                for (int j = track; j < n; j++) {
                    offset++;
                    if (i - offset >= 0)
                        diagonal[j][i - offset]++;
                    if (i + offset < n)
                        diagonal[j][i + offset]++;
                }
                used[i] = true;
                backtrack(n, track, used);
                offset = 0;
                for (int j = track; j < n; j++) {
                    offset++;
                    if (i - offset >= 0)
                        diagonal[j][i - offset]--;
                    if (i + offset < n)
                        diagonal[j][i + offset]--;
                }
                track--;
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}