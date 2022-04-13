package com.yc.leetcode.editor.cn;

import java.util.HashSet;

class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
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
        public boolean hasCycle(ListNode head) {
            HashSet<Integer> set = new HashSet<>();
            while (head != null) {
                int hash = head.hashCode();
                if (set.contains(hash))
                    return true;
                else
                    set.add(hash);
                head = head.next;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}