package com.yc.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode tail = new ListNode(0), head = tail;
            Queue<Integer> queue = new PriorityQueue<>();
            for (ListNode node : lists) {
                while (node != null) {
                    queue.offer(node.val);
                    node = node.next;
                }
            }
            while (!queue.isEmpty()) {
                tail.next = new ListNode(queue.poll());
                tail = tail.next;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}