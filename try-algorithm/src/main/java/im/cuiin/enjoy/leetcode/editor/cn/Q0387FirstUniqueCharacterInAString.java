/*
 * [387]字符串中的第一个唯一字符
 *
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// 👍 440 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * @author cuiin
 * @since 2021-09-19 10:35:00
 */
public class Q0387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new Q0387FirstUniqueCharacterInAString().new Solution();
    }

    /**
     * 暴力
     * O(n^2)
     */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean exists = false;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}