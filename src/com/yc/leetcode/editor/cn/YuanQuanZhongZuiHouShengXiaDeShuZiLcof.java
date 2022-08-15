package com.yc.leetcode.editor.cn;

class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            int res = 0;
            for (int i = 2; i <= n; i++)
                res = (res + m) % i;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}