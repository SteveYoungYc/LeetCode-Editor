package com.yc.leetcode.editor.cn;

class CarPooling {
    public static void main(String[] args) {
        Solution solution = new CarPooling().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int length = 0;
            for (int[] trip : trips) {
                length = Math.max(length, trip[2] + 1);
            }
            int[] diff = new int[length];
            for (int[] trip : trips) {
                diff[trip[1]] += trip[0];
                if (trip[2] < length)
                    diff[trip[2]] -= trip[0];
            }
            int num, lastNum = 0;
            for (int i = 0; i < length; i++) {
                num = lastNum + diff[i];
                lastNum = num;
                if (num > capacity)
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}