package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            int len = needle.length();
            if (needle.isEmpty())
                return 0;
            List<Integer> first = new ArrayList<>();
            List<Integer> last = new ArrayList<>();
            char f = needle.charAt(0);
            char l = needle.charAt(len - 1);
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == f)
                    first.add(i);
                if (haystack.charAt(i) == l)
                    last.add(i);
            }
            for (Integer i : first) {
                for (Integer j : last) {
                    if (j - i + 1 == len && haystack.substring(i, j + 1).equals(needle))
                        return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}