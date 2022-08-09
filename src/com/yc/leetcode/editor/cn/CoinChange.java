package com.yc.leetcode.editor.cn;

class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 1; i < amount + 1; i++) {
                dp[i] = -1;
            }
            for (int i = 0; i < amount + 1; i++) {
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    int idx = i - coin;
                    if (idx > 0 && dp[idx] != -1 || idx == 0) {
                        if (dp[idx] + 1 < min) {
                            min = dp[idx] + 1;
                            dp[i] = min;
                        }
                    }
                }
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}