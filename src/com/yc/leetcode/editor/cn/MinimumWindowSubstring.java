package com.yc.leetcode.editor.cn;

import java.util.HashMap;

class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int valid = 0;
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    int winCount = window.getOrDefault(c, 0);
                    window.put(c, ++winCount);
                    if (winCount == need.get(c))
                        valid++;
                }
                // System.out.println("window: [" + left + "," + right + ")");
                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        int winCount = window.get(d);
                        if (winCount == need.get(d))
                            valid--;
                        window.put(d, --winCount);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}