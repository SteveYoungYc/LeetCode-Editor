package com.yc.leetcode.editor.cn;

import java.util.Arrays;

class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] res = new int[n];
            int[] diff = new int[n];
            for (int[] book : bookings) {
                diff[book[0] - 1] += book[2];
                if (book[1] < n)
                    diff[book[1]] -= book[2];
            }
            res[0] = diff[0];
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}