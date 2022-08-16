package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class InterleavingString {
    public static void main(String[] args) {
        Solution solution = new InterleavingString().new Solution();
        solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if(s1.length() + s2.length() != s3.length()){
                return false;
            }
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i < s1.length() + 1; i++) {
                dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
            }
            for (int i = 1; i < s2.length() + 1; i++) {
                dp[0][i] = dp[0][i - 1] && s3.charAt(i - 1) == s2.charAt(i - 1);
            }
            for (int i = 1; i < s1.length() + 1; i++) {
                for (int j = 1; j < s2.length() + 1; j++) {
                    dp[i][j] = false;
                    char c = s3.charAt(i + j - 1);
                    boolean b1 = s1.charAt(i - 1) == c;
                    boolean b2 = s2.charAt(j - 1) == c;
                    if (b1 && dp[i - 1][j]) // i + 1说明使用了s1的字符
                        dp[i][j] = true;
                    if (b2 && dp[i][j - 1]) // j + 1说明使用了s2的字符
                        dp[i][j] = true;
                }
            }
            /*
            System.out.print("  0 ");
            for (int j = 1; j < s2.length() + 1; j++) {
                System.out.print(s2.charAt(j - 1) + " ");
            }
            System.out.println();
            for (int i = 0; i < s1.length() + 1; i++) {
                if (i >= 1)
                    System.out.print(s1.charAt(i - 1) + " ");
                else
                    System.out.print("0 ");
                for (int j = 0; j < s2.length() + 1; j++) {
                    System.out.print(dp[i][j] ? "T " : "F ");
                }
                System.out.println();
            }*/
            return dp[s1.length()][s2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}