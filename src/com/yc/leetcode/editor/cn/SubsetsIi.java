package com.yc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrace(nums, 0);
            return lists;
        }

        private void backtrace(int[] nums, int start) {
            lists.add(new LinkedList<>(track));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                track.add(nums[i]);
                backtrace(nums, i + 1);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}