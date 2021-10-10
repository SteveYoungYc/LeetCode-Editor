//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics String 👍 5523 👎 2503


package com.yc.leetcode.editor.en;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"a", ""};
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.print(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int minLength = Integer.MAX_VALUE;
            for (String str : strs) {
                if (str.length() < minLength) minLength = str.length();
            }
            int i = 0;
            for (i = 0; i < minLength + 1; i++) {
                for (String str : strs) {
                    if(i >= str.length() || i >= strs[0].length() || str.charAt(i) != strs[0].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return new String("");
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}