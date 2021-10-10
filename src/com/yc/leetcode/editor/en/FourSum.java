//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Two Pointers Sorting 👍 4537 👎 535


package com.yc.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        Solution solution = new FourSum().new Solution();
        System.out.print(solution.fourSum(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new LinkedList<>();
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int i, j, k, l, sum;
            for (i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (l = i + 1; l < nums.length - 2; l++) {
                    if (l > i + 1 && nums[l] == nums[l - 1]) continue;
                    sum = target - (nums[i] + nums[l]);
                    j = l + 1;
                    k = nums.length - 1;
                    while (k > j) {
                        if (nums[j] + nums[k] == sum) {
                            lists.add(Arrays.asList(nums[i], nums[l], nums[j], nums[k]));
                            while (k > j && nums[j] == nums[j + 1]) j++;
                            while (k > j && nums[k] == nums[k - 1]) k--;
                            j++;
                            k--;
                        } else if (nums[j] + nums[k] < sum) j++;
                        else k--;
                    }
                }
            }
            return lists;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}