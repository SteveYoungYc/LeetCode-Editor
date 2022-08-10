package com.yc.leetcode.editor.cn;

class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        solution.minDistance("horse", "ros");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // i，j 初始化指向最后一个索引
            return dp(s1, m - 1, s2, n - 1);
        }

        // 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
        int dp(String s1, int i, String s2, int j) {
            // base case
            if (i == -1) return j + 1;  // s1走到头，剩余的操作就是将s2剩余的字母全部添加
            if (j == -1) return i + 1;  // s2走到头，剩余的操作就是将s1剩余的字母全部删除

            if (s1.charAt(i) == s2.charAt(j)) {
                return dp(s1, i - 1, s2, j - 1); // 啥都不做
            }
            return min(
                    dp(s1, i, s2, j - 1) + 1,    // 插入
                    dp(s1, i - 1, s2, j) + 1,    // 删除
                    dp(s1, i - 1, s2, j - 1) + 1 // 替换
            );
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}