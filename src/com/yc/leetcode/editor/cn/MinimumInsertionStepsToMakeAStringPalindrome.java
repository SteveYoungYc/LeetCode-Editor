package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        Solution solution = new MinimumInsertionStepsToMakeAStringPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minInsertions(String s) {
            int n = s.length() + 1;
            int[][] dp = new int[n][n];
            for (int i = 1; i < n; i++) {
                for (int j = n - 2; j >= 0; j--) {
                    if (s.charAt(i - 1) == s.charAt(j))
                        dp[i][j] = dp[i - 1][j + 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
            return s.length() - dp[n - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}