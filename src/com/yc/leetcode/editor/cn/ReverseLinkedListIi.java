package com.yc.leetcode.editor.cn;
class ReverseLinkedListIi {
    public static void main(String[] args){
        Solution solution = new ReverseLinkedListIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int N;
    private ListNode node;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        node = head;
        N = right - left + 1;
        ListNode dummy = new ListNode(0, head);
        head = dummy;
        int i = left;
        while (i > 1) {
            head = head.next;
            i--;
        }
        i = right;
        while (i > 0) {
            node = node.next;
            i--;
        }
        head.next = reverseList(head.next, N);
        return dummy.next;
    }

    public ListNode reverseList(ListNode head, int n) {
        if (head == null || head.next == null || n == 1) {
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