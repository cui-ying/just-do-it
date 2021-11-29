/*
 * [198]打家劫舍
 *
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 1767 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * [198]打家劫舍
 * @author cuiin @ 2021-11-29 09:11:28
 */
public class Q0198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new Q0198HouseRobber().new Solution();
    }

    /**
     * <b>动态规划</b>
     * 优化：只会用到最近的值，所以，没必要搞个数组
     *
     * 状态定义：dp[i][j] 表示截止到第i家能得到的最高金额。j为0表示第i家不偷，为1表示偷。
     * 状态转移方程：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1])
     * dp[i][1] = dp[i-1][0] + nums[i]
     * 初始值：dp[0][0] = 0 , dp[0][1] = nums[0]
     * 输出：max(dp[nums.length-1][0], dp[nums.length-1][1]);
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int no = 0;
            int yes = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int tmpNo = no;
                no = Math.max(tmpNo, yes);
                yes = tmpNo + nums[i];
            }
            return Math.max(no, yes);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}