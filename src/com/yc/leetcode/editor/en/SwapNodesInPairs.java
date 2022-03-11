//Given a linked list, swap every two adjacent nodes and return its head. You 
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List Recursion 👍 4712 👎 248


package com.yc.leetcode.editor.en;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode result;
        for (int i = 3; i >= 1; i--) {
            head = new ListNode(i, head);
        }
        Solution solution = new SwapNodesInPairs().new Solution();
        result = solution.swapPairs(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            ListNode nodeA, nodeB;
            ListNode dummy = new ListNode(0, head);
            if (head.next == null) return head;
            nodeA = dummy;
            nodeB = dummy.next.next;
            while (nodeB != null) {
                if(nodeB.next != null)  nodeA.next.next = nodeB.next;
                else nodeA.next.next =null;
                nodeB.next = nodeA.next;
                nodeA.next = nodeB;
                nodeB = nodeB.next;

                if (nodeB.next != null) {
                    nodeB = nodeB.next.next;
                    nodeA = nodeA.next.next;
                }
                else break;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}