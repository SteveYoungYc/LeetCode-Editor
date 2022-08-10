package com.yc.leetcode.editor.cn;

class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        solution.minDistance("horse", "ros");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            dp[0][0] = 0;
            for (int i = 1; i < word1.length() + 1; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i < word2.length() + 1; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i < word1.length() + 1; i++) {
                for (int j = 1; j < word2.length() + 1; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = min( dp[i - 1][j],   // 从dp[i - 1][j]到dp[i][j]说明跳过了word1的一个字符，即删除
                                        dp[i][j - 1],   // 从dp[i][j - 1]到dp[i][j]说明跳过了word2的一个字符，即插入
                                        dp[i - 1][j - 1]) + 1;
                }
            }
            return dp[word1.length()][word2.length()];
        }

        private int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}