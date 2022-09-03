package com.yc.leetcode.editor.cn;

import java.util.*;

class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new OpenTheLock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Set<String> deadEndSet = new HashSet<>();
            Collections.addAll(deadEndSet, deadends);
            if (deadEndSet.contains("0000"))
                return -1;
            int step = 0;
            queue.offer("0000");
            visited.add("0000");
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();
                    visited.add(poll);
                    assert poll != null;
                    if (poll.equals(target))
                        return step;
                    for (int j = 0; j < 4; j++) {
                        String s = plusOne(poll, j);
                        if (!deadEndSet.contains(s) && !visited.contains(s)) {
                            queue.offer(s);
                            visited.add(s);
                        }
                        s = minusOne(poll, j);
                        if (!deadEndSet.contains(s) && !visited.contains(s)) {
                            queue.offer(s);
                            visited.add(s);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        String plusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '9')
                ch[j] = '0';
            else
                ch[j] += 1;
            return new String(ch);
        }

        String minusOne(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '0')
                ch[j] = '9';
            else
                ch[j] -= 1;
            return new String(ch);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}