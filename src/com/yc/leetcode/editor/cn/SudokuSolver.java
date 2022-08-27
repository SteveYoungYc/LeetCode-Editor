package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final char[][] res = new char[9][9];

        public void solveSudoku(char[][] board) {
            backtrace(board, 0);
            for (int k = 0; k < 9; k++) {
                System.arraycopy(res[k], 0, board[k], 0, 9);
            }
        }

        private void backtrace(char[][] board, int n) {
            int i = n / 9;
            int j = n % 9;
            if (board[i][j] != '.') {
                if (n < 80)
                    backtrace(board, n + 1);
                else {
                    for (int k = 0; k < 9; k++) {   // got it
                        System.arraycopy(board[k], 0, res[k], 0, 9);
                    }
                }
                return;
            }
            HashSet<Character> set = options(board, i, j);
            if (n == 80 && set.size() == 1) {   // got it
                for (int k = 0; k < 9; k++) {
                    System.arraycopy(board[k], 0, res[k], 0, 9);
                }
                for (Character c : set) {   // fill the last one
                    res[8][8] = c;
                }
            }
            for (Character c : set) {
                board[i][j] = c;
                if (n < 80)
                    backtrace(board, n + 1);
                board[i][j] = '.';
            }
        }

        private HashSet<Character> options(char[][] board, int i, int j) {
            HashSet<Character> set = new HashSet<>();
            for (char k = '1'; k <= '9'; k++) {
                set.add(k);
            }
            for (int k = 0; k < 9; k++) {
                set.remove(board[i][k]);    // remove characters displayed on the same row or line
                set.remove(board[k][j]);
            }
            int k = i - i % 3;
            int l = j - j % 3;
            for (int m = k; m < k + 3; m++) {
                for (int n = l; n < l + 3; n++) {
                    set.remove(board[m][n]);    // remove the characters displayed in the same 3*3 matrix
                }
            }
            return set;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}