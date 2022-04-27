package com.yc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class RandomPickWithBlacklist {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final HashMap<Integer, Integer> map = new HashMap<>();
        private final Random r = new Random();
        private final int size;

        public Solution(int n, int[] blacklist) {
            this.size = n - blacklist.length;
            HashSet<Integer> blackSet = new HashSet<>();
            for (int b : blacklist) {
                blackSet.add(b);
            }
            int index = n - 1;
            for (int j : blacklist) {
                if (j < size) {
                    while (blackSet.contains(index))
                        index--;
                    map.put(j, index);
                    index--;
                    blackSet.remove(j);
                }
            }
        }

        public int pick() {
            int num = r.nextInt(size);
            if (map.containsKey(num))
                num = map.get(num);
            return num;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}