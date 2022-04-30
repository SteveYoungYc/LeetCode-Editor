package com.yc.leetcode.editor.cn;

class SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
            int left = 0;
            int right = 1;
            int mid;
            for (int n : nums) {
                left = Math.max(left, n);
                right += n;
            }
            while (left < right) {
                mid = left + (right - left) / 2;
                if (calcM(nums, mid) <= m) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int calcM(int[] nums, int maxSum) {
            int m = 0;
            for (int i = 0; i < nums.length;) {
                int remain = maxSum;
                while (i < nums.length) {
                    if (remain < nums[i])
                        break;
                    else
                        remain -= nums[i];
                    i++;
                }
                m++;
            }
            return m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}