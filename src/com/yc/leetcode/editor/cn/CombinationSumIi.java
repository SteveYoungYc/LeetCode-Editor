package com.yc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrace(candidates, 0, target);
            return lists;
        }

        private void backtrace(int[] candidates, int start, int target) {
            if (target == 0) {
                lists.add(new LinkedList<>(track));
                return;
            }
            if (target < 0)
                return;
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                track.add(candidates[i]);
                target -= candidates[i];
                backtrace(candidates, i + 1, target);
                track.removeLast();
                target += candidates[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}