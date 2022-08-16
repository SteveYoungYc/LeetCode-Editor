package com.yc.leetcode.editor.cn;

class MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new MinimumAsciiDeleteSumForTwoStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) { // 删除的ASCII最小意味着寻找所有公共子序列中ASCII最大的一个
            int res = 0;
            int max = 0;
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            for (int i = 0; i < m; i++) {
                res += s1.charAt(i);
            }
            res -= max;
            for (int i = 0; i < n; i++) {
                res += s2.charAt(i);
            }
            res -= max;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}