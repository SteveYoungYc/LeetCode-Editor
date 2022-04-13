package com.yc.leetcode.editor.cn;

import java.util.HashSet;

class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            HashSet<Integer> set = new HashSet<>();
            while (head != null) {
                int hash = head.hashCode();
                if (set.contains(hash))
                    return head;
                else
                    set.add(hash);
                head = head.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}