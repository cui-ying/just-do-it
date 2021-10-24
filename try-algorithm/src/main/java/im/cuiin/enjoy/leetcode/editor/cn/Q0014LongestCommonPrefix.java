/*
 * [14]最长公共前缀
 *
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// 👍 1830 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * @author cuiin
 * @since 2021-10-24 08:24:49
 */
public class Q0014LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Q0014LongestCommonPrefix().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            boolean match = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() -1 < i || strs[j].charAt(i) != c) {
                    match = false;
                    break;
                }
            }

            if (match) {
                sb.append(c);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}