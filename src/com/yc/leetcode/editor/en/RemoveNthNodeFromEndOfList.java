//Given the head of a linked list, remove the nᵗʰ node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 👍 7104 👎 365


package com.yc.leetcode.editor.en;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode result;
        int n = 5;
        for (int i = 4; i >= 1; i--) {
            head = new ListNode(i, head);
        }
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        result = solution.removeNthFromEnd(head, n);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // Definition for singly-linked list.


    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode nodeA, nodeB;
            nodeA = new ListNode(0, head);
            nodeB = new ListNode(0, head);
            ListNode dummy = nodeA;
            for (int i = 0; i < n; i++) {
                nodeB = nodeB.next;
            }
            while (nodeB.next != null) {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            nodeA.next = nodeA.next.next;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
