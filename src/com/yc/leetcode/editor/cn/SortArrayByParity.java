package com.yc.leetcode.editor.cn;

class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int length = nums.length;
            int[] res = new int[length];
            int left = 0, right = length - 1;
            for (int num : nums) {
                if (num % 2 == 0) {
                    res[left] = num;
                    left++;
                } else {
                    res[right] = num;
                    right--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}