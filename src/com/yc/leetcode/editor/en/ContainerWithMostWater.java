//Given n non-negative integers a1, a2, ..., an , where each represents a point 
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
//of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the 
//x-axis forms a container, such that the container contains the most water. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: height = [4,3,2,1,4]
//Output: 16
// 
//
// Example 4: 
//
// 
//Input: height = [1,2,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics Array Two Pointers Greedy 👍 11896 👎 781


package com.yc.leetcode.editor.en;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] height = new int[]{2,3,10,5,7,8,9};
        System.out.print(solution.maxArea(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            /*
            int i = 0, j = height.length - 1;
            int max = (j - i) * Math.min(height[j], height[i]);
            while (j > i) {
                while (i < height.length - 1 && height[i + 1] <= height[i]) {
                    i++;
                }
                if (i < height.length - 1 && height[i + 1] > height[i]) {
                    max = Math.max(max, (j - i - 1) * Math.min(height[j], height[i + 1]));
                    i++;
                }

                while (j > 0 && height[j - 1] <= height[j]) {
                    j--;
                }
                if (j > 0 && height[j - 1] > height[j]) {
                    max = Math.max(max, (j - i - 1) * Math.min(height[j - 1], height[i]));
                    j--;
                }
            }
            return max;
             */
            int maxarea = 0, l = 0, r = height.length - 1;
            while (l < r) {
                maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
                if (height[l] < height[r])
                    l++;
                else
                    r--;
            }
            return maxarea;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}