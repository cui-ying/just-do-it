/*
 * [326]3 的幂
 *
//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
// Related Topics 递归 数学 👍 236 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * [326]3 的幂
 * @author cuiin @ 2021-12-07 09:23:21
 */
public class Q0326PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new Q0326PowerOfThree().new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE*3);
    }

    /**
     * 公式：log10(n) / log10(3) = 以3为底，n的对数。
     * 对数计算后的结果再对1取模，是为了判断是否为整数，如果为整数，即表示n是3的指数幂
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree(int n) {
            return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}