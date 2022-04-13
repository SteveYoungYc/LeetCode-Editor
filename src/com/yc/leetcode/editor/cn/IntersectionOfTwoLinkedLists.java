package com.yc.leetcode.editor.cn;

class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = 0, lenB = 0;
            ListNode a = headA, b = headB;
            while (a != null) {
                a = a.next;
                lenA++;
            }
            while (b != null) {
                b = b.next;
                lenB++;
            }
            a = headA;
            b = headB;
            if (lenA > lenB) {
                int i = lenA - lenB;
                while (i > 0) {
                    a = a.next;
                    i--;
                }
            } else if (lenB > lenA) {
                int i = lenB - lenA;
                while (i > 0) {
                    b = b.next;
                    i--;
                }
            }

            while (a != null) {
                if (a == b)
                    return a;
                a = a.next;
                b = b.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}