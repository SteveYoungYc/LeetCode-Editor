package com.yc.leetcode.editor.cn;

class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new DeleteOperationForTwoStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length() + 1;
            int n = word2.length() + 1;
            int[][] dp = new int[m][n];
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
            return word1.length() + word2.length() - dp[m - 1][n - 1] * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}