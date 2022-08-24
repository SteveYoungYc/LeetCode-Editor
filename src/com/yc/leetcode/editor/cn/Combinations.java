package com.yc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> lists = new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            backtrace(new LinkedList<>(), n, k, 1);
            return lists;
        }

        private void backtrace(LinkedList<Integer> track, int n, int k, int start) {
            if (track.size() == k) {
                lists.add(new LinkedList<>(track));
                return;
            }
            for (int i = start; i <= n; i++) {
                track.add(i);
                backtrace(track, n, k, i + 1);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}