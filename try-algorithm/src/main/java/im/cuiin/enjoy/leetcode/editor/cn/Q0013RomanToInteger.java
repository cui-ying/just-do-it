/*
 * [13]罗马数字转整数
 *
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "III"
//输出: 3 
//
// 示例 2: 
//
// 
//输入: s = "IV"
//输出: 4 
//
// 示例 3: 
//
// 
//输入: s = "IX"
//输出: 9 
//
// 示例 4: 
//
// 
//输入: s = "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: s = "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 15 
// s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M') 
// 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内 
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。 
// IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。 
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。 
// 
// Related Topics 哈希表 数学 字符串 👍 1604 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.HashMap;

/**
 * [13]罗马数字转整数
 * @author cuiin @ 2021-12-08 09:11:33
 */
public class Q0013RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new Q0013RomanToInteger().new Solution();
        solution.romanToInt("CMXCIX");
    }

    /**
     * 遍历
     * 先两个字符去搜索，若查到说明这两个字符是一组。否则，再退为一个字符去搜索。
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> romaMap = new HashMap<>();
        romaMap.put("I",	1);
        romaMap.put("V",	5);
        romaMap.put("X",	10);
        romaMap.put("L",	50);
        romaMap.put("C",	100);
        romaMap.put("D",	500);
        romaMap.put("M",	1000);
        romaMap.put("IV",	4);
        romaMap.put("IX",	9);
        romaMap.put("XL",	40);
        romaMap.put("XC",	90);
        romaMap.put("CD",	400);
        romaMap.put("CM",	900);

        int rst = 0;
        int i = 0;
        while (i < s.length()) {
            Integer v = null;

            if (i + 2 <= s.length()) {
                v = romaMap.get(s.substring(i, i + 2));
            }

            if (v == null) {
                v = romaMap.get(s.substring(i, i+1));
                i++;
            } else {
                i += 2;
            }

            rst += v;
        }
        return rst;
    }
}
//--leetcode submit region end(Prohibit modification and deletion)

}