package com.yc.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class SlidingPuzzle {
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
        int[][] board = {{4, 1, 2}, {5, 0, 3}};
        solution.slidingPuzzle(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Board {
            public int[][] val;
            public int x;
            public int y;

            public Board(int[][] board) {
                this.val = new int[2][3];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        this.val[i][j] = board[i][j];
                        if (board[i][j] == 0) {
                            this.x = i;
                            this.y = j;
                        }
                    }
                }
            }

            public Set<Board> nexts() {
                Set<Board> set = new HashSet<>();
                Board board;
                if (x > 0) {
                    board = new Board(val);
                    board.x--;
                    board.val[x][y] = val[board.x][y];
                    board.val[board.x][y] = 0;
                    set.add(board);
                }
                if (x < 1) {
                    board = new Board(val);
                    board.x++;
                    board.val[x][y] = val[board.x][y];
                    board.val[board.x][y] = 0;
                    set.add(board);
                }
                if (y > 0) {
                    board = new Board(val);
                    board.y--;
                    board.val[x][y] = val[x][board.y];
                    board.val[x][board.y] = 0;
                    set.add(board);
                }
                if (y < 2) {
                    board = new Board(val);
                    board.y++;
                    board.val[x][y] = val[x][board.y];
                    board.val[x][board.y] = 0;
                    set.add(board);
                }
                return set;
            }

            @Override
            public boolean equals(Object obj) {
                Board other = (Board) obj;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (val[i][j] != other.val[i][j]) {
                            return false;
                        }
                    }
                }
                return true;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            public boolean Ok() {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == 1 && j == 2)
                            break;
                        if (i * 3 + j != val[i][j] - 1) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }

        public int slidingPuzzle(int[][] board) {
            Queue<Board> queue = new LinkedList<>();
            Set<Board> visited = new HashSet<>();
            int step = 0;
            queue.offer(new Board(board));
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Board b = queue.poll();
                    assert b != null;
                    visited.add(b);
                    if (b.Ok()) {
                        return step;
                    }
                    Set<Board> nexts = b.nexts();
                    for (Board next : nexts) {
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
                if (queue.isEmpty())
                    return -1;
                step++;
            }
            return step;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}