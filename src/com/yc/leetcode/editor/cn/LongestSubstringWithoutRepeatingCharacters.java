package com.yc.leetcode.editor.cn;

import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            int left = 0, right = 0;
            int len = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                while (set.contains(c)) {
                    char d = s.charAt(left);
                    left++;
                    set.remove(d);
                }
                set.add(c);
                len = Math.max(len, set.size());
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}