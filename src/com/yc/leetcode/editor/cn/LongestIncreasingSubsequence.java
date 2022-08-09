package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];    //dp[i]表示以nums[i]结尾的最长递增子序列的长度
            int max = 1;
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            for (int j : dp) {
                if (j > max)
                    max = j;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}