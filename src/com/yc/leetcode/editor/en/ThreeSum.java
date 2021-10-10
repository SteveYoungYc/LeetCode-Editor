//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 13225 👎 1280


package com.yc.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {};
        Solution solution = new ThreeSum().new Solution();
        System.out.print(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new LinkedList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int sum, j, k;
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                sum = -nums[i];
                j = i + 1;
                k = nums.length - 1;
                while (k > j) {
                    if (nums[j] + nums[k] == sum) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (k > j && nums[j] == nums[j + 1]) j++;
                        while (k > j && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < sum) j++;
                    else k--;
                }
            }
            return lists;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
