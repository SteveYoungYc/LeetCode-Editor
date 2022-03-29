//给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。 
//
// 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离
//。 
//
// 返回一对观光景点能取得的最高分。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// 示例 2： 
//
// 
//输入：values = [1,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 2 <= values.length <= 5 * 10⁴ 
// 1 <= values[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 299 👎 0


package com.yc.leetcode.editor.cn;

public class BestSightseeingPair {
    public static void main(String[] args) {
        Solution solution = new BestSightseeingPair().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int left = values[0], res = Integer.MIN_VALUE;
            for (int j = 1; j < values.length; j++) {
                res = Math.max(res, left + values[j] - j);
                left = Math.max(left, values[j] + j);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}