package com.yc.leetcode.editor.cn;

import java.util.Arrays;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int maxSquare = matrix[0][0] - '0';
            int[][] dp = new int[m][n];
            dp[0][0] = matrix[0][0] - '0';
            for (int i = 1; i < m; i++) {
                dp[i][0] = matrix[i][0] - '0';
                if (matrix[i][0] == '1')
                    maxSquare = 1;
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = matrix[0][i] - '0';
                if (matrix[0][i] == '1')
                    maxSquare = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        maxSquare = Math.max(maxSquare, dp[i][j]);
                        if (dp[i - 1][j - 1] >= 1 && isOne(matrix, i, j, dp[i - 1][j - 1])) {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                            maxSquare = Math.max(maxSquare, dp[i][j]);
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return maxSquare * maxSquare;
        }

        private boolean isOne(char[][] matrix, int i, int j, int length) {
            for (int k = i - length; k < i; k++) {
                if (matrix[k][j] == '0')
                    return false;
            }
            for (int k = j - length; k < j; k++) {
                if (matrix[i][k] == '0')
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}