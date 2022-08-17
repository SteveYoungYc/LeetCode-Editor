package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class DungeonGame {
    public static void main(String[] args) {
        Solution solution = new DungeonGame().new Solution();
        int[][] dungeon = new int[3][3];
        solution.calculateMinimumHP(dungeon);
    }
    /**
     *  1 -3  3
     *  0 -2  0
     * -3 -3 -3
     * */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 可以看作一条上下浮动的曲线，要确定这条曲线的y轴偏移，使得此曲线的最小值大于0。
         * 若曲线从一开始单调递增，那么初始值可以逐渐减小。
         * 只要曲线开始下降，之后增加也没有用。
         * */
        class DungeonNode {
            int minVal = 0;
            int curVal = 0;
        }

        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            DungeonNode[][] dp = new DungeonNode[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = new DungeonNode();
                }
            }
            dp[0][0].minVal = dungeon[0][0];
            dp[0][0].curVal = dungeon[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0].curVal = dp[i - 1][0].curVal + dungeon[i][0];
                dp[i][0].minVal = Math.min(dp[i][0].curVal, dp[i - 1][0].minVal);
            }
            for (int i = 1; i < n; i++) {
                dp[0][i].curVal = dp[0][i - 1].curVal + dungeon[0][i];
                dp[0][i].minVal = Math.min(dp[0][i].curVal, dp[0][i - 1].minVal);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    int currUp = dp[i - 1][j].curVal + dungeon[i][j];
                    int minUp = Math.min(dp[i - 1][j].minVal, currUp);
                    int currLeft = dp[i][j - 1].curVal + dungeon[i][j];
                    int minLeft = Math.min(dp[i][j - 1].minVal, currLeft);
                    if (minUp < minLeft) {  // 不知道是当前血量更高更好，还是最小值更大更好
                        dp[i][j].minVal = minLeft;
                        dp[i][j].curVal = currLeft;
                    } else {
                        dp[i][j].minVal = minUp;
                        dp[i][j].curVal = currUp;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(dp[i][j].curVal + " " + dp[i][j].minVal + "   ");
                }
                System.out.println();
            }
            if (dp[m - 1][n - 1].minVal > 0)
                return 1;
            else
                return 1 - dp[m - 1][n - 1].minVal;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}