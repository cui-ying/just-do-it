/*
 * [125]验证回文串
 *
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// 👍 417 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * @author cuiin
 * @since 2021-09-21 10:16:22
 */
public class Q0125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Q0125ValidPalindrome().new Solution();
    }

    /**
     * 双指针，递归
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            return helper(s, 0, s.length() -1);
        }

        private boolean helper(String s, int left, int right) {
            /* 如果 left 指针已经到 right 指针右边了，那么说明之前的字符都合法 */
            if (left >= right) {
                return true;
            }

            /* 过滤无效的 left 元素 */
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }
            /* 过滤无效的 right 元素 */
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }
            /* 比较左右元素是否相等 */
            return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)) && helper(s, ++left, --right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}