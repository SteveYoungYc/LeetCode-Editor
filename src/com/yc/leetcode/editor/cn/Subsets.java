package com.yc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            backtrace(nums, new LinkedList<>(), 0);
            return lists;
        }

        private void backtrace(int[] nums, LinkedList<Integer> track, int start) {
            lists.add(new LinkedList<>(track));
            for (int i = start; i < nums.length; i++) {
                track.add(nums[i]);
                backtrace(nums, track, i + 1);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}