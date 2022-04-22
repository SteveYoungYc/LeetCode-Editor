package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int valid = 0;
            for (int i = 0; i < p.length(); i++) {
                char pc = p.charAt(i);
                need.put(pc, need.getOrDefault(pc, 0) + 1);
            }
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    int winCount = window.getOrDefault(c, 0);
                    window.put(c, ++winCount);
                    if (winCount == need.get(c))
                        valid++;
                }
                while (valid == need.size()) {
                    if (right - left == p.length()) {
                        list.add(left);
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
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}