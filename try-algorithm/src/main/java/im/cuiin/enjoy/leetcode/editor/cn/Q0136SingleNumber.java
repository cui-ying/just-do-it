/*
 * [136]只出现一次的数字
 *
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// 👍 2002 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cuiin
 * @since 2021-09-04 16:14:48
 */
public class Q0136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Q0136SingleNumber().new Solution();
    }

    /**
     * 暴力统计。
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> cache = new HashSet<>();

        for (int num : nums) {
            if (!cache.add(num)) {
                cache.remove(num);
            }
        }
//        return cache.iterator().next();
        return (int) cache.toArray()[0];
    }
}
//--leetcode submit region end(Prohibit modification and deletion)

}