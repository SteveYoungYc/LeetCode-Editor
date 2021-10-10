//Given an integer array nums of length n and an integer target, find three 
//integers in nums such that the sum is closest to target. 
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0], target = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics Array Two Pointers Sorting 👍 4410 👎 205


package com.yc.leetcode.editor.en;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.print(solution.threeSumClosest(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int result;
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum, j, k, minVal;
            result = nums[0] + nums[1] + nums[nums.length - 1];
            minVal = Math.abs(result - target);
            for (int i = 0; i < nums.length - 2; i++) {
                sum = target - nums[i];
                j = i + 1;
                k = nums.length - 1;
                while (k > j) {
                    if (minVal > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        result = nums[i] + nums[j] + nums[k];
                        minVal = Math.abs(result - target);
                    }
                    if (nums[j] + nums[k] < sum) j++;
                    else k--;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}