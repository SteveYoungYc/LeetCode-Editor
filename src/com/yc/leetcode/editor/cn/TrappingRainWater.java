//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3279 👎 0


package com.yc.leetcode.editor.cn;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int length = height.length;
            int water = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (height[j] >= height[i]) {
                        int w = waterSum(i + 1, j - 1, height[i], height);
                        water += w;
                        i = j;
                    }
                }
            }
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (height[j] >= height[i]) {
                        int w = waterSum(j + 1, i - 1, height[i], height);
                        water += w;
                        i = j;
                    }
                }
            }
            return water;
        }

        private int waterSum(int start, int end, int h, int[] height) {
            int water = 0;
            for (int i = start; i <= end; i++) {
                water += (h - height[i]);
                height[i] = h;
            }
            return water;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}