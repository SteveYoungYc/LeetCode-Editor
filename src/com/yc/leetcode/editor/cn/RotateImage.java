package com.yc.leetcode.editor.cn;

class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int n;

        public void rotate(int[][] matrix) {
            n = matrix.length;
            int rowLen = n / 2;
            int colLen = n / 2 + n % 2;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    rotateFour(matrix, i, j);
                }
            }
        }
        /*
        * matrix[i][j]              matrix[j][offset - i]
        * matrix[offset - j][i]     matrix[offset - i][offset - j]
        */
        private void rotateFour(int[][] matrix, int i, int j) {
            int offset = n - 1;
            int tmp = matrix[j][offset - i];
            matrix[j][offset - i] = matrix[i][j];
            matrix[i][j] = matrix[offset - j][i];
            matrix[offset - j][i] = matrix[offset - i][offset - j];
            matrix[offset - i][offset - j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}