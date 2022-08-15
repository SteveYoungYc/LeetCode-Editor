package com.yc.leetcode.editor.cn;

class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length() + 1;
            int[][] dp = new int[n][n];
            for (int i = 1; i < n; i++) {
                for (int j = n - 2; j >= 0; j--) {
                    if (s.charAt(i - 1) == s.charAt(j))
                        dp[i][j] = dp[i - 1][j + 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]);
                }
            }
            return dp[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}