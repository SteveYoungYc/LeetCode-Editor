package com.yc.leetcode.editor.cn;

class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution solution = new IncreasingOrderSearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root.left == null && root.right == null)
                return root;
            TreeNode newRoot = root;
            if (root.left != null) {
                TreeNode left = increasingBST(root.left);
                newRoot = left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root;
            }
            root.left = null;
            if (root.right != null) {
                root.right = increasingBST(root.right);
            }
            return newRoot;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}