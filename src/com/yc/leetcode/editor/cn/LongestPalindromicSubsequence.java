package com.yc.leetcode.editor.cn;

class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            String reverse = new StringBuffer(s).reverse().toString();
            int n = s.length() + 1;
            int[][] dp = new int[n][n];
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (s.charAt(i - 1) == reverse.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
            return dp[n - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}