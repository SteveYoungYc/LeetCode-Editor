package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class RangeSumQuery2dImmutable {

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            int rowLen = matrix.length;
            int colLen = matrix[0].length;
            sums = new int[rowLen + 1][colLen + 1];
            for (int i = 1; i < rowLen + 1; i++) {
                for (int j = 1; j < colLen + 1; j++) {
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}