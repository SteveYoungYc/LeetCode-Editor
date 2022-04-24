package com.yc.leetcode.editor.cn;

class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 1000000000 + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (calcTime(piles, mid) <= h) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int calcTime(int[] piles, int k) {
            int time = 0;
            for (int pile : piles) {
                time += pile / k;   // Integer division is much faster than double division!
                if (pile % k > 0)
                    time++;
            }
            return time;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}