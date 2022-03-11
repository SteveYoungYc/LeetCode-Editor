//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics String Dynamic Programming Backtracking 👍 10029 👎 402


package com.yc.leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 4;
        Solution solution = new GenerateParentheses().new Solution();
        System.out.print(solution.generateParenthesis(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        StringBuilder s = new StringBuilder();
        List<String> result = new LinkedList<>();
        public List<String> generateParenthesis(int n) {
            s.append("()");
            result.add(s.toString());
            while (result.get(0).length() != 2 * n) {
                String string = result.remove(0);
                if((string + "()").equals("()" + string)) {
                    result.add(string + "()");
                }
                else {
                    result.add(string + "()");
                    result.add("()" + string);
                }
                result.add("(" + string + ")");
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

/*
["()(())()"]
["(())(())"]
 */
