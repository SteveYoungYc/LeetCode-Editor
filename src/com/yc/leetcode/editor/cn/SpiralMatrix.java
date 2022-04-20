package com.yc.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
            int i, j;
            int num = matrix.length * matrix[0].length;
            while (true) {
                for (j = left; j <= right; j++) {
                    list.add(matrix[up][j]);
                }
                if (list.size() == num)
                    break;
                up++;
                for (i = up; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                if (list.size() == num)
                    break;
                right--;
                for (j = right; j >= left; j--) {
                    list.add(matrix[down][j]);
                }
                if (list.size() == num)
                    break;
                down--;
                for (i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                if (list.size() == num)
                    break;
                left++;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}