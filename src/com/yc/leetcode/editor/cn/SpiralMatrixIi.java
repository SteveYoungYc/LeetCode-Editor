package com.yc.leetcode.editor.cn;

class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int up = 0, down = n - 1, left = 0, right = n - 1;
            int i, j;
            int num = 0;
            while (num < n * n) {
                for (j = left; j <= right; j++) {
                    num++;
                    matrix[up][j] = num;
                }
                up++;
                for (i = up; i <= down; i++) {
                    num++;
                    matrix[i][right] = num;
                }
                right--;
                for (j = right; j >= left; j--) {
                    num++;
                    matrix[down][j] = num;
                }
                down--;
                for (i = down; i >= up; i--) {
                    num++;
                    matrix[i][left] = num;
                }
                left++;
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}