package com.yc.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args){
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                Node lastNode = null;
                for (int i = 0; i < n; i++) {
                    Node node = queue.poll();
                    if (lastNode != null) {
                        lastNode.next = node;
                    }
                    lastNode = node;
                    if (node != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}