/*
 * [121]买卖股票的最佳时机
 *
//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
// Related Topics 数组 动态规划 👍 1958 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author cuiin @ 2021-11-27 08:50:21
 */
public class Q0121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new Q0121BestTimeToBuyAndSellStock().new Solution();
    }

    /**
     * <p>暴力：嵌套循环</p>
     *
     * 外层遍历买入点，内层遍历卖出点，max 变量记录最大收益。
     *
     * 有问题：Time Limit Exceeded
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff > max) {
                    max = diff;
                }
            }
        }

        return max;
    }
}
//--leetcode submit region end(Prohibit modification and deletion)

}