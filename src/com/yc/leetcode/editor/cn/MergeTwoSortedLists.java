package com.yc.leetcode.editor.cn;

//java:Merge Two Sorted Lists
class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            while (list1 != null && list2 != null) {
                while (list1 != null && list1.val < list2.val) {
                    head.next = new ListNode(list1.val);
                    list1 = list1.next;
                    head = head.next;
                }
                while (list1 != null && list2 != null && list2.val <= list1.val) {
                    head.next = new ListNode(list2.val);
                    list2 = list2.next;
                    head = head.next;
                }
            }
            while (list1 != null) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
                head = head.next;
            }
            while (list2 != null) {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
                head = head.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}