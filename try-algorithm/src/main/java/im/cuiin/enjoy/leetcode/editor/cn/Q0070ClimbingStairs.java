/*
 * [70]爬楼梯
 *
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// 👍 2023 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * @author cuiin
 * @since 2021-11-23 09:06:02
 */
public class Q0070ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q0070ClimbingStairs().new Solution();
    }

    /*
    动态规划 + 递归
    状态定义：
    dp(n) : 爬到第n级台阶的方法数量。
    初始值：
    dp(1) = 1, dp(2) = 2;
    状态转移方程：
    第n级可以是跳1级过来，可以是跳2级过来。
    dp(n) = dp(n-1) + dp(n-2)
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
//--leetcode submit region end(Prohibit modification and deletion)

}