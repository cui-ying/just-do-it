/*
 * [1]两数之和
 *
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// 👍 12011 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author cuiin
 * @since 2021-09-05 15:15:29
 */
public class Q0001TwoSum {
    public static void main(String[] args) {
        Solution solution = new Q0001TwoSum().new Solution();
    }

    /**
     * 暴力解法：两层循环
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
//--leetcode submit region end(Prohibit modification and deletion)


    /**
     * map 缓存。
     * 一层循环，每次先检查差值是否在map中，若在则返回下标；否则，将当前值与下标放入map缓存。
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (map.get(target - nums[i]) == null) {
                    map.put(nums[i], i);
                } else {
                    return new int[]{map.get(target - nums[i]), i};
                }
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}