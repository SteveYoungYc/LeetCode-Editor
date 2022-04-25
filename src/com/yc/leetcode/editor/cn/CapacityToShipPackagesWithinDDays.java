package com.yc.leetcode.editor.cn;

class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0;
            int right = 1;
            for (int w : weights) {
                left = Math.max(left, w);
                right += w;
            }

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (calcDays(weights, mid) <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        public int calcDays(int[] weights, int capacity) {
            int days = 0;
            for (int i = 0; i < weights.length; ) {
                int cap = capacity;
                while (i < weights.length) {
                    if (cap < weights[i])
                        break;
                    else
                        cap -= weights[i];
                    i++;
                }
                days++;
            }
            // System.out.println("capacity: " + capacity + " days " + days);
            return days;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}