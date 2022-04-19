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

        private void rotateFour(int[][] matrix, int i, int j) {
            int offset = n - 1;
            int a = matrix[i][j];
            int b = matrix[j][offset - i];
            int c = matrix[offset - i][offset - j];
            int d = matrix[offset - j][i];
            matrix[j][offset - i] = a;
            matrix[offset - i][offset - j] = b;
            matrix[offset - j][i] = c;
            matrix[i][j] = d;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}