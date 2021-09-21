/*
 * [242]有效的字母异位词
 *
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// 👍 432 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author cuiin
 * @since 2021-09-20 08:12:15
 */
public class Q0242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Q0242ValidAnagram().new Solution();
    }

    /**
     * 计数，比对
     */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCounter = new int[26];
        int[] tCounter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCounter[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            tCounter[t.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCounter[i] != tCounter[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}