package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * sum1 - sum2 = target
         * sum1 = target + sum2
         * sum1 * 2 = target + sum
         * sum1 = (target + sum) / 2
         * */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
                return 0;
            }
            int m = nums.length + 1;
            int n = (target + sum) / 2 + 1;
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}