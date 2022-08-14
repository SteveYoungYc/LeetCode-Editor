package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 1; i < text1.length() + 1; i++) {
                for (int j = 1; j < text2.length() + 1; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) // 若两字母相同直接加1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);    // 若两字母不同，则取最大值 如kbk bsb最后k!=b，取kb和bsb或者kbk和bs的最大
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}