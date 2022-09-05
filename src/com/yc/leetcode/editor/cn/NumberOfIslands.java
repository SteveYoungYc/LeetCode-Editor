package com.yc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int m;
        private int n;
        private int res = 0;
        private boolean[][] visited;
        private Queue<Point> queue = new LinkedList<>();

        private class Point {
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0')
                        visited[i][j] = true;
                    if (visited[i][j])
                        continue;
                    bfs(grid, i, j);
                }
            }
            return res;
        }

        private void bfs(char[][] grid, int i, int j) {
            queue.offer(new Point(i, j));
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    Point point = queue.poll();
                    assert point != null;
                    int x = point.x;
                    int y = point.y;
                    visited[x][y] = true;
                    // explore the current island
                    if (x - 1 >= 0 && !visited[x - 1][y] && grid[x - 1][y] == '1') {
                        visited[x - 1][y] = true;
                        queue.offer(new Point(x - 1, y));
                    }
                    if (x + 1 < m && !visited[x + 1][y] && grid[x + 1][y] == '1') {
                        visited[x + 1][y] = true;
                        queue.offer(new Point(x + 1, y));
                    }
                    if (y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] == '1') {
                        visited[x][y - 1] = true;
                        queue.offer(new Point(x, y - 1));
                    }
                    if (y + 1 < n && !visited[x][y + 1] && grid[x][y + 1] == '1') {
                        visited[x][y + 1] = true;
                        queue.offer(new Point(x, y + 1));
                    }
                }
            }
            res++;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}