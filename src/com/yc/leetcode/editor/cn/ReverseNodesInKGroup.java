package com.yc.leetcode.editor.cn;

class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        private int N;
        private ListNode node;
        public ListNode reverseKGroup(ListNode head, int k) {
            N = k;
            ListNode dummy = new ListNode(0, head);
            node = head;
            head = dummy;
            while (true) {
                for (int j = 0; j < k; j++) {
                    if (node != null)
                        node = node.next;
                    else
                        return dummy.next;
                }
                head.next = reverseList(head.next, k);
                for (int j = 0; j < k; j++) {
                    head = head.next;
                }
            }
        }

        public ListNode reverseList(ListNode head, int n) {
            if (n == 1) {
                return head;
            }
            ListNode last = reverseList(head.next, n - 1);
            head.next.next = head;
            if (n == N)
                head.next = node;
            else
                head.next = null;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}