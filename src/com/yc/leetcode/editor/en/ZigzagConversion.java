//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
// Related Topics String 👍 2803 👎 6696


package com.yc.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        String s = new String("PAYPALISHIRING");
        int numRows = 3;
        System.out.print(solution.convert(s, numRows));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;

            List<StringBuilder> rows = new ArrayList<>();
            int row = Math.min(numRows, s.length());
            int l = 0;
            int cycleLen = 2 * numRows - 2;
            for (int i = 0; i < row; i++) {
                rows.add(new StringBuilder());

                l = s.length();
                for (int j = 0; l > 0; j++) {
                    int a = i + j * cycleLen;
                    if (a < s.length()) {
                        rows.get(i).append(s.charAt(a));
                    }
                    if (i != 0 && i != row - 1) {
                        if ((j + 1) * cycleLen - i < s.length())
                            rows.get(i).append(s.charAt((j + 1) * cycleLen - i));
                    }
                    l -= cycleLen;
                }
            }
            StringBuilder ret = new StringBuilder();
            for (StringBuilder r : rows) ret.append(r);
            return ret.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}