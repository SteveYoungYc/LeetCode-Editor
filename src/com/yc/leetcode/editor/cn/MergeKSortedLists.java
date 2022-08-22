package com.yc.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                return null;
            ListNode head = new ListNode(-1), tail = head;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(    // 队列长度只有k
                    lists.length, Comparator.comparingInt(a -> a.val));
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(node);
                }
            }
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                tail.next = node;
                if (node.next != null) {
                    queue.offer(node.next);
                }
                tail = tail.next;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}