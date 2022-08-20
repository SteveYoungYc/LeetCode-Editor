package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            List<Integer> left = new ArrayList<>();
            list.add("(");
            right.add(1);   // 还能用几个右括号
            left.add(1);    // 用了几个左括号
            while (true) {
                int size = list.size();
                for (int j = 0; j < size; j++) {
                    String s = list.get(j);
                    int l = left.get(j), r = right.get(j);
                    if (l < n) {    // 还有可以使用的左括号，修改j处的字符串
                        list.set(j, s + "(");
                        left.set(j, l + 1);
                        right.set(j, r + 1);
                        if (r > 0) {    // 还有可以使用的右括号，在list尾部添加s + ")"
                            list.add(s + ")");
                            right.add(r - 1);
                            left.add(l);
                        }
                    } else if (r > 0) { // 没有可以使用的左括号但有可以使用的右括号，修改j处的字符串
                        list.set(j, s + ")");
                        right.set(j, r - 1);
                    }
                }
                boolean brkFlg = true;
                for (int i = 0; i < list.size(); i++) { // 可以用的右括号为0并且所有左括号都用完之后，即可break
                    if (right.get(i) != 0 || left.get(i) != n) {
                        brkFlg = false;
                        break;
                    }
                }
                if (brkFlg)
                    break;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}