package com.yc.leetcode.editor.cn;

class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        solution.flatten(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        TreeNode list;

        public void flatten(TreeNode root) {
            list = new TreeNode(0);
            TreeNode dummy = list;
            preOrder(root);
            if (dummy.right != null) {
                root.left = dummy.right.left;
                root.right = dummy.right.right;
            }
        }

        public void preOrder(TreeNode root) {
            if (root == null)
                return;
            list.right = new TreeNode(root.val);
            list = list.right;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}