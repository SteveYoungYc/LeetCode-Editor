package com.yc.leetcode.editor.cn;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0)
                return null;
            int rootVal = preorder[0];
            TreeNode root = new TreeNode(rootVal);
            int rootPos = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootVal) {
                    rootPos = i;
                    break;
                }
            }
            int leftLen = rootPos;
            int rightLen = inorder.length - rootPos - 1;
            int[] leftInorder = new int[leftLen];
            int[] rightInorder = new int[rightLen];
            int[] leftPreorder = new int[leftLen];
            int[] rightPreorder = new int[rightLen];
            System.arraycopy(inorder, 0, leftInorder, 0, leftLen);
            System.arraycopy(inorder, rootPos + 1, rightInorder, 0, rightLen);
            System.arraycopy(preorder, 1, leftPreorder, 0, leftLen);
            System.arraycopy(preorder, rootPos + 1, rightPreorder, 0, rightLen);
            root.left = buildTree(leftPreorder, leftInorder);
            root.right = buildTree(rightPreorder, rightInorder);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}