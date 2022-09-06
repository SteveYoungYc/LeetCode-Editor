package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Boundary implements Comparable<Boundary> {
            int val;
            int type;

            public Boundary(int val, int type) {
                this.val = val;
                this.type = type;   // 0 for left, 1 for right
            }

            @Override
            public int compareTo(Boundary o) {
                if (this.val == o.val) {
                    return Integer.compare(this.type, o.type); // Left is smaller when vals are the same
                }
                return Integer.compare(this.val, o.val);
            }
        }

        public int[][] merge(int[][] intervals) {
            int[][] res;
            PriorityQueue<Boundary> queue = new PriorityQueue<>();
            Stack<Boundary> stack = new Stack<>();
            List<int[]> lists = new ArrayList<>();
            for (int[] interval : intervals) {
                queue.offer(new Boundary(interval[0], 0));
                queue.offer(new Boundary(interval[1], 1));
            }
            assert queue.peek() != null;
            int minVal = queue.peek().val;  // leftest bracket's val
            while (!queue.isEmpty()) {
                Boundary boundary = queue.poll();
                if (minVal == -1)
                    minVal = boundary.val;
                if (boundary.type == 0) {
                    stack.add(boundary);
                }
                if (boundary.type == 1) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        lists.add(new int[]{minVal, boundary.val});
                        minVal = -1;    // refresh minVal
                    }
                }
            }
            res = new int[lists.size()][2];
            for (int i = 0; i < lists.size(); i++) {
                res[i][0] = lists.get(i)[0];
                res[i][1] = lists.get(i)[1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}