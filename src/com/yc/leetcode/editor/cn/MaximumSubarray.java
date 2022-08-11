package com.yc.leetcode.editor.cn;

class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res, sum;
            int lastSum = nums[0];
            res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (lastSum < 0)
                    sum = nums[i];
                else
                    sum = lastSum + nums[i];
                lastSum = sum;
                if (sum > res)
                    res = sum;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}