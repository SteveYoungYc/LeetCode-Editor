package com.yc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1. choose father
         * 2. choose left child
         * 3. choose right child
         * 4. choose both children
         * */
        Map<TreeNode, Integer> memo = new HashMap<>();  // memorandum
        public int rob(TreeNode root) {
            if (root == null)
                return 0;
            if (memo.containsKey(root)) // check the memorandum
                return memo.get(root);
            int robRoot = root.val; // rob root and the children of the children of root
            if (root.left != null) {
                robRoot += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                robRoot += rob(root.right.left) + rob(root.right.right);
            }
            int noRoot; // rob the children of root
            noRoot = rob(root.left) + rob(root.right);
            int res = Math.max(robRoot, noRoot);
            memo.put(root, res);    // write the memorandum
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}