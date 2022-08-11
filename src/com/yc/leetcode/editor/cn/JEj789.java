package com.yc.leetcode.editor.cn;

class JEj789 {
    public static void main(String[] args) {
        Solution solution = new JEj789().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            int res;
            int[][] dp = new int[costs.length][3];
            System.arraycopy(costs[0], 0, dp[0], 0, 3);
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
            }
            int idx = dp.length - 1;
            res = Math.min(dp[idx][0], dp[idx][1]);
            res = Math.min(res, dp[idx][2]);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}