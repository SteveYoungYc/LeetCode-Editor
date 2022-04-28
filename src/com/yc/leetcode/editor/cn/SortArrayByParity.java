package com.yc.leetcode.editor.cn;

class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int length = nums.length;
            int left = 0, right = length - 1;
            while (left < right) {
                while (left < length && nums[left] % 2 == 0) {
                    left++;
                }
                while (right >=0 && nums[right] % 2 == 1) {
                    right--;
                }
                if (left < right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}