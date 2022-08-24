package com.yc.leetcode.editor.cn;

import java.util.*;

class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<Integer, List<Integer>> dp = new HashMap<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            for (int i = 0; i <= target; i++) {
                List<Integer> list = new ArrayList<>();
                dp.put(i, list);
                for (int candidate : candidates) {
                    int last = i - candidate;
                    if ((last > 0 && !dp.get(last).isEmpty()) || last == 0) {
                        list.add(candidate);
                    }
                }
            }
            boolean[] used = new boolean[target + 1];
            backtrack(new LinkedList<>(), target, used);
            return lists;
        }

        private void backtrack(LinkedList<Integer> track, int target, boolean[] used) {
            System.out.println(target + " " + track);
            if (target == 0)
                lists.add(new LinkedList(track));
            List<Integer> list = dp.get(target);
            for (Integer i : list) {
                if (used[i]) {
                    continue;
                }
                track.add(i);
                backtrack(track, target - i, used);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}