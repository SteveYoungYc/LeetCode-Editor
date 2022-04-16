package com.yc.leetcode.editor.cn;

class RangeSumQueryImmutable {
    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            int length = nums.length;
            sums = new int[length + 1];
            for (int i = 1; i < length + 1; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}