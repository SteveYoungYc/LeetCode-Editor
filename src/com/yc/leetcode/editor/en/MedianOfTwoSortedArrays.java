//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics Array Binary Search Divide and Conquer 👍 12355 👎 1684


package com.yc.leetcode.editor.en;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{2,3,4,5,6};
        System.out.print(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if(m == 0) return n % 2 == 0 ? (double) (nums2[n / 2] + nums2[n / 2 - 1]) / 2 : nums2[n / 2];
            if(n == 0) return m % 2 == 0 ? (double) (nums1[m / 2] + nums1[m / 2 - 1]) / 2 : nums1[m / 2];
            if(m == 1 && n == 1) return (double) (nums1[0] + nums2[0]) / 2;
            double mid1 = m % 2 == 1 ? nums1[m / 2] : (double) (nums1[m / 2] + nums1[m / 2 - 1]) / 2;
            double mid2 = n % 2 == 1 ? nums2[n / 2] : (double) (nums2[n / 2] + nums2[n / 2 - 1]) / 2;
            int[][] range = {{0, m - 1},
                            {0, n - 1}};
            while (range[0][1] - range[0][0] != 1 || range[1][1] - range[1][0] != 1) {
                if (mid1 >= mid2) {
                    range[0][1] /= 2;
                    range[1][0] = range[1][1] / 2;
                } else {
                    range[1][1] /= 2;
                    range[0][0] = range[0][1] / 2;
                }
            }
            int[] midArray = new int[4];
            midArray[0] = nums1[range[0][0]]; midArray[1] = nums1[range[0][1]];
            midArray[2] = nums2[range[1][0]]; midArray[3] = nums2[range[1][1]];
            Arrays.sort(midArray);
            return (double) (midArray[1] + midArray[2]) / 2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    class BrutalSolution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int i = 0, j = 0, k = 0;
            int midIndex = (m + n) / 2 + 1;
            int[] temp = new int[midIndex];

            if(n == 0) return m % 2 == 0 ? (double) (nums2[m / 2] + nums2[m / 2 - 1]) / 2 : nums2[m / 2];
            if(m == 0) return n % 2 == 0 ? (double) (nums1[n / 2] + nums1[n / 2 - 1]) / 2 : nums1[n / 2];
            if(m == 1 && n == 1) return (double) (nums1[0] + nums2[0]) / 2;

            while (k < (m + n) / 2 + 1) {
                while (i < n && j < m && nums1[i] <= nums2[j] && k < (m + n) / 2 + 1) {
                    temp[k] = nums1[i];
                    i++;
                    k++;
                }
                if (i == n && j < m - 1) {
                    while (k < (m + n) / 2 + 1 && j < m) {
                        temp[k] = nums2[j];
                        j++;
                        k++;
                    }
                    break;
                }

                while (i < n && j < m && nums1[i] >= nums2[j] && k < (m + n) / 2 + 1) {
                    temp[k] = nums2[j];
                    j++;
                    k++;
                }
                if (j == m && i < n - 1) {
                    while (k < (m + n) / 2 + 1 && i < n) {
                        temp[k] = nums1[i];
                        i++;
                        k++;
                    }
                    break;
                }
            }

            if ((m + n) % 2 == 0) {
                return ((double) (temp[(m + n) / 2 - 1] + temp[(m + n) / 2])) / 2;
            } else {
                return temp[(m + n) / 2];
            }
        }
    }
}
