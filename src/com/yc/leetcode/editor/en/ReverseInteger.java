//Given a signed 32-bit integer x, return x with its digits reversed. If 
//reversing x causes the value to go outside the signed 32-bit integer range [-2³¹, 2³¹ -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed 
//or unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics Math 👍 5644 👎 8425


package com.yc.leetcode.editor.en;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int x = 1534236469;
        System.out.print(solution.reverse(x));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long result = 0;
            Stack<Integer> stack = new Stack<>();
            while (x != 0) {
                stack.push(x % 10);
                x /= 10;
            }
            int i = 0;
            while (!stack.empty()) {
                result += stack.pop() * Math.pow(10, i);
                ++i;
            }
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            return (int)result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}