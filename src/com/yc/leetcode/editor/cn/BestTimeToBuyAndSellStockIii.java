package com.yc.leetcode.editor.cn;

class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 0)
                return 0;
            int k = 2;
            int[][][] dp = new int[n][k + 1][2];
            for (int t = 0; t <= k; t++) {  // 第0天买入之后为-prices[0]
                dp[0][t][1] = -prices[0];
            }
            for (int d = 1; d < n; d++) {   // days
                for (int t = 1; t <= k; t++) {  // transactions
                    int buy, rest, sell;
                    sell = dp[d - 1][t][1] + prices[d]; // 本次交易购买之后加上今日
                    rest = dp[d - 1][t][0]; // 本次交易完成之后
                    dp[d][t][0] = Math.max(sell, rest); // no stock
                    buy = dp[d - 1][t - 1][0] - prices[d];  // 上次交易完成之后减去今日
                    rest = dp[d - 1][t][1]; // 本次交易购买之后
                    dp[d][t][1] = Math.max(buy, rest);  // having stock
                }
            }
            return dp[n - 1][k][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}