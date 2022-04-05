//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 1260 👎 0


package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new LinkedList<>();
        int[][] board;

        public List<List<String>> solveNQueens(int n) {
            board = new int[n][n];
            LinkedList<String> track = new LinkedList<>();
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strings.add(generateStr(i, n));
            }
            backtrack(strings, track);
            return res;
        }

        void backtrack(List<String> strings, LinkedList<String> track) {
            int n = strings.size();
            if (track.size() == n) {
                res.add(new LinkedList(track));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (board[track.size()][i] != 0)
                    continue;
                track.add(strings.get(i));
                int offset = 0;
                for (int j = track.size(); j < n; j++) {
                    offset++;
                    if (i - offset >= 0)
                        board[j][i - offset]++;
                    if (i + offset < n)
                        board[j][i + offset]++;
                    board[j][i]++;
                }
                backtrack(strings, track);
                offset = 0;
                for (int j = track.size(); j < n; j++) {
                    offset++;
                    if (i - offset >= 0)
                        board[j][i - offset]--;
                    if (i + offset < n)
                        board[j][i + offset]--;
                    board[j][i]--;
                }
                track.removeLast();
            }
        }

        String generateStr(int i, int n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i)
                    stringBuilder.append("Q");
                else
                    stringBuilder.append(".");
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}