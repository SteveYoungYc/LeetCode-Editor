//Given a string s representing a valid expression, implement a basic 
//calculator to evaluate it, and return the result of the evaluation. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid). 
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid). 
//
// There will be no two consecutive operators in the input. 
// Every number and running calculation will fit in a signed 32-bit integer. 
// 
// Related Topics Math String Stack Recursion 👍 3414 👎 286


package com.yc.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculator{
    public static void main(String[] args) {
         Solution solution = new BasicCalculator().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ) {
                stack.push(i);
            }
        }
        return 0;
    }

    private int toNum(String s) {
        int num = 0;
        int cursor = s.length() - 1;
        while (cursor > 0) {
            num = num * 10 + (s.charAt(cursor) - '0');
            cursor--;
        }
        return num;
    }

    private int calculateSingle(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {

        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}