package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        solution.inorderTraversal(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            midOrder(root);
            return list;
        }

        private void midOrder(TreeNode root) {
            if (root == null)
                return;
            midOrder(root.left);
            list.add(root.val);
            midOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}