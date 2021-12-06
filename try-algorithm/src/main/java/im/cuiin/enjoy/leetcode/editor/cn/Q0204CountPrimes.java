/*
 * [204]计数质数
 *
//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 790 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * [204]计数质数
 * @author cuiin @ 2021-12-03 09:17:28
 */
public class Q0204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new Q0204CountPrimes().new Solution();
        solution.countPrimes(0);
        solution.countPrimes(1);
        solution.countPrimes(2);
        solution.countPrimes(3);
        solution.countPrimes(10);
        solution.countPrimes(15);
    }

    /**
     * 两层迭代，优化：提取方法
     */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        int times = 0;
        if (n < 3) {
            return times;
        }

        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                times++;
            }
        }
        return times;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}