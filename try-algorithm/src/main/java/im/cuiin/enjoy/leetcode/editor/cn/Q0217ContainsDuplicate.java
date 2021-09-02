/*
 * [217]存在重复元素
 *
//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// 👍 461 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cuiin
 * @since 2021-09-02 09:11:16
 */
public class Q0217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Q0217ContainsDuplicate().new Solution();
    }

    /**
     * 排序后遍历，任何相邻两个元素相等，即存在重复
     *
     * 时间复杂度：快排 O(NlogN)
     * 空间复杂度：由于要临时存储数据，O(N)
     */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        } // else
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //--leetcode submit region begin(Prohibit modification and deletion)
    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return false;
            } // else

            Set<Integer> cache = new HashSet<>();
            for (int num : nums) {
                boolean exist = cache.contains(num);
                // 如果已存在相同的元素记录，则说明重复了，直接返回 true。
                if (exist) {
                    return true;
                } else {
                    cache.add(num);
                }
            }
            return false;
        }
    }
//--leetcode submit region end(Prohibit modification and deletion)


    //--leetcode submit region begin(Prohibit modification and deletion)
    class Solution3 {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return false;
            } // else

            Set<Integer> cache = new HashSet<>();
            for (int num : nums) {
                // 若添加失败，则说明已存在相同元素，返回 true。
                if (!cache.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }
//--leetcode submit region end(Prohibit modification and deletion)
}