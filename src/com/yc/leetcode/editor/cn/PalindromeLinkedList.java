package com.yc.leetcode.editor.cn;

import java.util.Stack;

class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            int len = 0;
            while (fast != null && fast.next != null) {
                len++;
                fast = fast.next.next;
                slow = slow.next;
            }
            slow = reverseList(slow);
            for (int i = 0; i < len; i++) {
                if (slow.val != head.val)
                    return false;
                slow = slow.next;
                head = head.next;
            }
            return true;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}