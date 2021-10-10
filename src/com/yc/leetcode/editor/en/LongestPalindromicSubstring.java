//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 13265 👎 793


package com.yc.leetcode.editor.en;
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
         Solution solution = new LongestPalindromicSubstring().new Solution();
         String s = "abc435cba";
         String result = solution.longestPalindrome(s);
         System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            int maxLength = 0, endIndex = 0;
            String t = new StringBuffer(s).reverse().toString();
            int[] mat = new int[length];
            for (int i = 0; i < length; i++) {  //row i
                for (int j = length - 1; j >= 0; j--) { //column j
                    if (s.charAt(i) == t.charAt(j)) {
                        if(i > 0 && j > 0)  mat[j] = 1 + mat[j - 1];    //Update the array from the end
                        else mat[j] = 1;
                    }
                    else {
                        mat[j] = 0;
                    }
                    if (mat[j] > maxLength) {
                        //Prevent abc435cba from being identified as a palindrome substring.
                        if (j - mat[j] + 1 == length - 1 - i) {  //j - mat[j] + 1 is the real position after reversing, length - 1 - i is theoretical position
                            maxLength = mat[j];
                            endIndex = i;
                        }
                    }
                    //System.out.print(mat[j] + " ");
                }
                //System.out.println();
            }
            return s.substring(endIndex - maxLength + 1, endIndex + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}