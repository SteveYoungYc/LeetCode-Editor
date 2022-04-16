package com.yc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class GameOfLife {
    public static void main(String[] args) {
        Solution solution = new GameOfLife().new Solution();
        solution.gameOfLife(new int[][]{});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Point {
            public int m;
            public int n;

            public Point(int m, int n) {
                this.m = m;
                this.n = n;
            }
        }

        HashMap<Point, Integer> map;
        int rowLen;
        int colLen;

        public void gameOfLife(int[][] board) {
            rowLen = board.length;
            colLen = board[0].length;
            map = new HashMap();
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    simulate(board, i, j);
                }
            }
            for (Map.Entry<Point, Integer> entry : map.entrySet()) {
                board[entry.getKey().m][entry.getKey().n] = entry.getValue();
            }
        }

        private void simulate(int[][] board, int i, int j) {
            int count = 0;
            for (int k = Math.max(0, i - 1); k <= Math.min(i + 1, rowLen - 1); k++) {
                for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, colLen - 1); l++) {
                    if (k == i && l == j)
                        continue;
                    if (board[k][l] == 1)
                        count++;
                }
            }
            if (board[i][j] == 1 && (count < 2 || count > 3)) {
                map.put(new Point(i, j), 0);
            }
            if (board[i][j] == 0 && count == 3) {
                map.put(new Point(i, j), 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}