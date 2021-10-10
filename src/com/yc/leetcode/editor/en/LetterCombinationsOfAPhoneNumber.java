//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 👍 7522 👎 582


package com.yc.leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "234";
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.print(solution.letterCombinations(digits));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        public List<String> letterCombinations(String digits) {

            if (digits.isEmpty()) return ans;
            ans.add("");
            for (int i = 0; i < digits.length(); i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while (ans.peek().length() == i) { //查看队首元素
                    String t = ans.remove(); //队首元素出队
                    for (char s : mapping[x].toCharArray())
                        ans.add(t + s);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}