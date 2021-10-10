//Given two integers a and b, return the sum of the two integers without using 
//the operators + and -. 
//
// 
// Example 1: 
// Input: a = 1, b = 2
//Output: 3
// Example 2: 
// Input: a = 2, b = 3
//Output: 5
// 
// 
// Constraints: 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics Math Bit Manipulation 👍 1969 👎 3067


package com.yc.leetcode.editor.en;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new SumOfTwoIntegers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            String aBin = Integer.toBinaryString(a);
            String bBin = Integer.toBinaryString(b);

            return a + b;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}