//Given an integer x, return true if x is palindrome integer. 
//
// An integer is a palindrome when it reads the same backward as forward. For 
//example, 121 is palindrome while 123 is not. 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it 
//becomes 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Example 4: 
//
// 
//Input: x = -101
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without converting the integer to a string? 
//Related Topics Math 👍 3991 👎 1858


package com.yc.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        int x = 0;
        System.out.print(solution.isPalindrome(x));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            Stack<Integer> stack = new Stack<Integer>();
            Queue<Integer> queue = new LinkedList<>();
            if (x < 0) {
                return false;
            }
            while (x > 0) {
                stack.push(x % 10);
                queue.add(x % 10);
                x /= 10;
            }
            while (!stack.empty()) {
                if(!Objects.equals(stack.pop(), queue.remove()))
                    return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}