/*
 * [283]移动零
 *
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// 👍 1207 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * @author cuiin
 * @since 2021-09-05 14:48:24
 */
public class Q0283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new Q0283MoveZeroes().new Solution();
    }

    /**
     * 双指针
     */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i != j) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }

        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}