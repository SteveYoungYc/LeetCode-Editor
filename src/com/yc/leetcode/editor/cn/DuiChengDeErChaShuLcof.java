//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 311 👎 0


package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = null;
        root.right.left = new TreeNode(2);
        root.right.right = null;
        solution.isSymmetric(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private List<Integer> preList;
        private List<Integer> postList;

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            preList = new ArrayList<>();
            postList = new ArrayList<>();
            preOrderTraverse1(root);
            postOrderTraverse1(root);
            System.out.println(preList);
            System.out.println(postList);
            for (int i = 0; i < preList.size(); i++) {
                if (postList.get(i) != preList.get(i))
                    return false;
            }
            return true;
        }

        public void preOrderTraverse1(TreeNode root) {
            if (root != null) {
                preOrderTraverse1(root.left);
                preList.add(root.val);
                preOrderTraverse1(root.right);
            } else {
                preList.add(Integer.MAX_VALUE);
            }
        }

        public void postOrderTraverse1(TreeNode root) {
            if (root != null) {
                postOrderTraverse1(root.right);
                postList.add(root.val);
                postOrderTraverse1(root.left);
            } else {
                postList.add(Integer.MAX_VALUE);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}