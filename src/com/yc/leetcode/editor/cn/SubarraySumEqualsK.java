package com.yc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int res = 0, sum_i = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int num : nums) {
                sum_i += num;
                if (map.containsKey(sum_i - k))
                    res += map.get(sum_i - k);
                map.put(sum_i, map.getOrDefault(sum_i, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}