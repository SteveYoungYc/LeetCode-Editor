package com.yc.leetcode.editor.cn;

class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            if (len == 1)
                return nums[0];
            if (len == 2)
                return Math.max(nums[0], nums[1]);
            if (len == 3)
                return Math.max(nums[0], Math.max(nums[1], nums[2]));
            // 抢头不抢尾，0抢，1不抢，len-1不抢
            dp[2] = nums[2];
            dp[3] = Math.max(nums[2], nums[3]);
            for (int i = 4; i < len - 1; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            int res = dp[len - 2] + nums[0];
            // 抢尾不枪头，0不抢，len-1抢，len-2不抢
            dp[1] = nums[1];
            dp[2] = Math.max(nums[1], nums[2]);
            for (int i = 3; i < len - 2; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            res = Math.max(res, dp[len - 3] + nums[len - 1]);
            // 头尾都不抢，0不抢，len-1不抢，len-2抢，1抢
            dp[1] = nums[1];
            dp[2] = Math.max(nums[1], nums[2]);
            for (int i = 3; i < len - 1; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            res = Math.max(res, dp[len - 2]);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}