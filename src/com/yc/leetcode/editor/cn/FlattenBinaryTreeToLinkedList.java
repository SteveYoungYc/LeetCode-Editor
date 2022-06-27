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
     * 1. 将左子树插入到右子树的地方。
     * 2. 将原来的右子树接到左子树的最右边节点。
     * 3. 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null。
     *
     * 很好理解，前序遍历先遍历根节点，然后遍历左子树，最后遍历右子树。所以要把左子树插入右子树之前。
     */
    class Solution {
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left != null) {
                    TreeNode node = root.left;
                    while (node.right != null) {
                        node = node.right;
                    }
                    node.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}