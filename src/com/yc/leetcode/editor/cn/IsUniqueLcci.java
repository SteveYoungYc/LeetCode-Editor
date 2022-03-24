//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 位运算 哈希表 字符串 排序 👍 198 👎 0


package com.yc.leetcode.editor.cn;
public class IsUniqueLcci{
    public static void main(String[] args) {
         Solution solution = new IsUniqueLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {
        boolean[] bitmap = new boolean[255];
        for (int i = 0; i < astr.length(); i++) {
            byte c = (byte) astr.charAt(i);
            if (bitmap[c]) {
                return false;
            }
            bitmap[c] = true;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}