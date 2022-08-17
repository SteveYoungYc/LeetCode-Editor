package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 > 0)
                return false;
            sum /= 2;
            int m = nums.length + 1;
            int n = sum + 1;
            boolean[][] dp = new boolean[m][n]; // boolean默认值为false
            dp[0][0] = true;
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}