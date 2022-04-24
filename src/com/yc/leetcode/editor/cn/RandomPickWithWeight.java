package com.yc.leetcode.editor.cn;

import java.util.Random;

class RandomPickWithWeight {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length;
        private int[] preSum;
        Random r = new Random();

        public Solution(int[] w) {
            length = w.length;
            preSum = new int[length + 1];
            for (int i = 1; i < length + 1; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
        }

        public int pickIndex() {
            int index = 0;
            int ran = r.nextInt(preSum[length]);
            index = binarySearch(preSum, ran);
            return index;
        }

        private int binarySearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return right;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}