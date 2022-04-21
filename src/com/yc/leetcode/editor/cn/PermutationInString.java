package com.yc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int valid = 0;
            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    int winCount = window.getOrDefault(c, 0);
                    window.put(c, ++winCount);
                    if (winCount == need.get(c))
                        valid++;
                }
                // System.out.println("window: [" + left + "," + right + ")");
                while (valid == need.size()) {
                    if (right - left == s1.length()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        int winCount = window.get(d);
                        if (winCount == need.get(d))
                            valid--;
                        window.put(d, --winCount);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}