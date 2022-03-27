//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 👍 511 👎 0


package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ShuDeZiJieGouLcof{
    public static void main(String[] args) {
         Solution solution = new ShuDeZiJieGouLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null)
            return false;

        List<TreeNode> queue = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            if (node != null) {
                if (node.val == B.val) {
                    List<TreeNode> queue1 = new ArrayList<>();
                    List<Integer> list1 = new ArrayList<>();
                    queue1.add(B);
                    while (!queue1.isEmpty()) {
                        TreeNode node1 = queue1.remove(0);
                        if (node1 != null) {
                            list1.add(node.val);
                            queue1.add(node.left);
                            queue1.add(node.right);
                        }
                    }
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}