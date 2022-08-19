package com.yc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Line {
            double slope;
            double offset;

            Line(double slope, double offset) {
                this.slope = slope;
                this.offset = offset;
            }

            @Override
            public boolean equals(Object otherObj) {
                if (this == otherObj) {  //测试检测的对象是否为空，是就返回false
                    return true;
                }
                if (otherObj == null) {  //测试两个对象所属的类是否相同，否则返回false
                    return false;
                }
                if (getClass() != otherObj.getClass()) {  //对otherObject进行类型转换以便和类A的对象进行比较
                    return false;
                }
                Line other = (Line) otherObj;
                return Math.abs(this.slope - other.slope) < 0.000001 && Math.abs(this.offset - other.offset) < 0.000001;
            }

            @Override
            public int hashCode() {
                return (int) (slope + offset);
            }
        }

        private class Point {
            int x;
            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object otherObj) {
                if (this == otherObj) {  //测试检测的对象是否为空，是就返回false
                    return true;
                }
                if (otherObj == null) {  //测试两个对象所属的类是否相同，否则返回false
                    return false;
                }
                if (getClass() != otherObj.getClass()) {  //对otherObject进行类型转换以便和类A的对象进行比较
                    return false;
                }
                Point other = (Point) otherObj;
                return this.x == other.x && this.y == other.y;
            }

            @Override
            public int hashCode() {
                return x + y;
            }
        }

        public int maxPoints(int[][] points) {
            if (points.length <= 2)
                return points.length;
            HashMap<Line, HashSet<Point>> lines = new HashMap<>();
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    double slope, offset;
                    if (points[j][0] - points[i][0] == 0) {
                        slope = Double.MAX_VALUE;
                        offset = points[j][0];
                    } else {
                        slope = (double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                        offset = points[j][1] - slope * points[j][0];
                    }
                    // System.out.println(offset);
                    Line line = new Line(slope, offset);
                    Point p1 = new Point(points[i][0], points[i][1]);
                    Point p2 = new Point(points[j][0], points[j][1]);
                    if (lines.containsKey(line)) {
                        lines.get(line).add(p1);
                        lines.get(line).add(p2);
                    } else {
                        lines.put(line, new HashSet<>());
                    }
                }
            }
            int res = 2;
            for (HashSet<Point> set : lines.values()) {
                if (set.size() > res)
                    res = set.size();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}