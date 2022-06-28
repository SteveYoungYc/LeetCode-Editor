package com.yc.leetcode.editor.cn;

class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                TreeNode node = root.left;
                root.left = root.right;
                root.right = node;
                invertTree(root.left);
                invertTree(root.right);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}