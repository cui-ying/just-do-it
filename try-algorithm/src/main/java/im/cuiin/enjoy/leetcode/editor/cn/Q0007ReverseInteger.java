/*
 * [7]整数反转
 *
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// 👍 3087 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * @author cuiin
 * @since 2021-09-19 09:18:46
 */
public class Q0007ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Q0007ReverseInteger().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int newRes = res * 10 + x % 10;
            if ((newRes - x % 10) / 10 != res) {
                return 0;
            }

            x = x / 10;
            res = newRes;
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}