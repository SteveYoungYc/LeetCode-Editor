//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 👍 9277 👎 365


package com.yc.leetcode.editor.en;

import java.util.Objects;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        Solution solution = new ValidParentheses().new Solution();
        System.out.print(solution.isValid(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Stack<String> stack = new Stack<>();
        public boolean isValid(String s) {
            for (int i = 0; i < s.length(); i++) {
                switch (String.valueOf(s.charAt(i))) {
                    case "(" -> stack.push(")");
                    case "[" -> stack.push("]");
                    case "{" -> stack.push("}");
                    case ")" -> {
                        if (stack.empty() || !Objects.equals(stack.pop(), ")")) return false;
                    }
                    case "]" -> {
                        if (stack.empty() || !Objects.equals(stack.pop(), "]")) return false;
                    }
                    case "}" -> {
                        if (stack.empty() || !Objects.equals(stack.pop(), "}")) return false;
                    }
                }
            }
            return stack.empty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}