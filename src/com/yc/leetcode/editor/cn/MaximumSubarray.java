package com.yc.leetcode.editor.cn;

class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res;
            int[] dp = new int[nums.length];    // dp[i]表示以nums[i]结尾的最大子数组和
            dp[0] = nums[0];
            res = dp[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i - 1] < 0)
                    dp[i] = nums[i];
                else
                    dp[i] = dp[i - 1] + nums[i];
                if (dp[i] > res)
                    res = dp[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}