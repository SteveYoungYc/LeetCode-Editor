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
            if (n % 2 == 1) {
                for (int i = 0; i <= n / 2; i++) {
                    for (int j = 1; j <= n / 2; j++) {
                        rotateOdd(matrix, i, j);
                    }
                }
            } else {
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < n / 2; j++) {
                        rotateEven(matrix, i, j);
                    }
                }
            }
        }

        private void rotateOdd(int[][] matrix, int i, int j) {
            int offset = n / 2;
            int a = matrix[offset + i][offset + j];
            int b = matrix[offset + j][offset - i];
            int c = matrix[offset - i][offset - j];
            int d = matrix[offset - j][offset + i];
            matrix[offset + i][offset + j] = d;
            matrix[offset + j][offset - i] = a;
            matrix[offset - i][offset - j] = b;
            matrix[offset - j][offset + i] = c;
        }

        private void rotateEven(int[][] matrix, int i, int j) {
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