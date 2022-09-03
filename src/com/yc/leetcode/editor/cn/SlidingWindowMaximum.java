package com.yc.leetcode.editor.cn;

import java.util.LinkedList;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class MonotonicQueue {
            LinkedList<Integer> maxQueue = new LinkedList<>();
            public void push(int n) {
                while (!maxQueue.isEmpty() && maxQueue.getLast() < n) {
                    maxQueue.pollLast();
                }
                maxQueue.addLast(n);
            }

            public int max() {
                return maxQueue.getFirst();
            }

            public void pop(int n) {
                if (n == maxQueue.getFirst()) {
                    maxQueue.pollFirst();
                }
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            MonotonicQueue queue = new MonotonicQueue();
            for (int i = 0; i < k; i++) {
                queue.push(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                res[i - k] = queue.max();
                queue.push(nums[i]);
                queue.pop(nums[i - k]);
            }
            res[nums.length - k] = queue.max();
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}