/*
 * [53]最大子序和
 *
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4024 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * [53]最大子序和
 * @author cuiin @ 2021-11-28 08:12:07
 */
public class Q0053MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Q0053MaximumSubarray().new Solution();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int rst = solution.maxSubArray(nums);
        assert rst == 6;
    }

    /**
     * 暴力：两层循环
     * Time Limit Exceeded
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = -10001;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
//--leetcode submit region end(Prohibit modification and deletion)

}