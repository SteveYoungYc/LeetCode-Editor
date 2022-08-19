package com.yc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums2.length;
            int[] res = new int[nums1.length];
            Stack<Integer> s = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            // 倒着往栈里放
            for (int i = n - 1; i >= 0; i--) {
                // 判定个子高矮
                while (!s.isEmpty() && s.peek() <= nums2[i]) {
                    // 矮个起开，反正也被挡着了。。。
                    s.pop();
                }
                // nums[i] 身后的更大元素
                int num = s.isEmpty() ? -1 : s.peek();
                s.push(nums2[i]);
                map.put(nums2[i], num);
            }
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}