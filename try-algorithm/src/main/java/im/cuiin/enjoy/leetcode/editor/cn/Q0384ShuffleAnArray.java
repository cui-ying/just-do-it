/*
 * [384]打乱数组
 *
//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。 
//
// 实现 Solution class: 
//
// 
// Solution(int[] nums) 使用整数数组 nums 初始化对象 
// int[] reset() 重设数组到它的初始状态并返回 
// int[] shuffle() 返回数组随机打乱后的结果 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁶ <= nums[i] <= 10⁶ 
// nums 中的所有元素都是 唯一的 
// 最多可以调用 5 * 10⁴ 次 reset 和 shuffle 
// 
// Related Topics 数组 数学 随机化 👍 240 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Random;

/**
 * [384]打乱数组
 * @author cuiin @ 2021-11-29 10:36:39
 */
public class Q0384ShuffleAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution solution = new Q0384ShuffleAnArray().new Solution(nums);
        int[] rst = solution.shuffle();
        int[] rst1 = solution.reset();
        int[] rst2 = solution.shuffle();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[] nums;
        private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
//        int i = random.nextInt(nums.length);
        int[] newArray = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(nums.length);
            swap(newArray, i, j);
        }


        return newArray;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}