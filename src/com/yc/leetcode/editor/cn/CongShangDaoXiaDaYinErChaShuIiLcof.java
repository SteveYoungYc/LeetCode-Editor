//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
// Related Topics 树 广度优先搜索 二叉树 👍 196 👎 0


package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
        List<List<Integer>> node = new ArrayList();

        public List<List<Integer>> levelOrder(TreeNode root) {
            lei(root, 0);
            return node;
        }

        public void lei(TreeNode root, int k) {
            if (root != null) {
                if (node.size() <= k) node.add(new ArrayList());
                node.get(k).add(root.val);
                lei(root.left, k + 1);
                lei(root.right, k + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}