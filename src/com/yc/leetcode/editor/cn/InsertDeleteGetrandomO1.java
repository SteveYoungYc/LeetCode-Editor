package com.yc.leetcode.editor.cn;

import java.util.*;

class InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        private int size;
        private final HashMap<Integer, Integer> map;
        private final List<Integer> list;
        private final Random random;

        public RandomizedSet() {
            size = 0;
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, size);
            if (list.size() > size)
                list.set(size, val);
            else
                list.add(val);
            size++;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int lastElement = list.get(size - 1);
            list.set(index, lastElement);
            map.replace(lastElement, index);
            map.remove(val);
            size--;
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(size);
            return list.get(index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}