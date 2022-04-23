package com.yc.leetcode.editor.cn;

class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[2];
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    int i = mid - 1, j = mid + 1;
                    while (i >= 0 && nums[i] == target)
                        i--;
                    while (j < nums.length && nums[j] == target)
                        j++;
                    res[0] = i + 1;
                    res[1] = j - 1;
                    return res;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}