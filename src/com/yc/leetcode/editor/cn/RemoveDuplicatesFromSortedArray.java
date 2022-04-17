package com.yc.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int length = nums.length;
            int slow = 0, fast = 1;
            while (fast < length) {
                while (fast < length && nums[fast] == nums[slow])
                    fast++;
                if (fast < length) {
                    nums[slow + 1] = nums[fast];
                    slow++;
                }
            }
            return slow + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}