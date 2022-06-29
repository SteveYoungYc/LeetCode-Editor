package com.yc.leetcode.editor.cn;

import java.util.HashMap;

class MaximumBinaryTree {
    public static void main(String[] args){
        Solution solution = new MaximumBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
//    private HashMap<Integer, Integer> map = new HashMap<>();
//    private boolean sortFlag = false;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        int maxVal = Integer.MIN_VALUE;
        int maxPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxPos = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        int[] leftNums = new int[maxPos];
        int[] rightNums = new int[nums.length - maxPos - 1];
        System.arraycopy(nums, 0, leftNums, 0, maxPos);
        System.arraycopy(nums, maxPos + 1, rightNums, 0, nums.length - maxPos - 1);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}