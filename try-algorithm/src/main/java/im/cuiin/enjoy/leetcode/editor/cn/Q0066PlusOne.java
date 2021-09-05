/*
 * [66]加一
 *
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// 👍 741 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * @author cuiin
 * @since 2021-09-05 13:14:59
 */
public class Q0066PlusOne {
    public static void main(String[] args) {
        Solution solution = new Q0066PlusOne().new Solution();
    }

    /**
     * for 循环
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >=0 ; i--) {
            if (i==0 && digits[i] + carry > 9) {
                int[] tmp = new int[digits.length +1] ;
                tmp[0] = 1;
                tmp[1] = 0;
                System.arraycopy(digits, 1, tmp, 2, digits.length - 1);
                digits = tmp;
                break;
            }

            if (digits[i] + carry > 9) {
                digits[i] = 0;
            } else {
                digits[i] += carry;
                break;
            }
        }

        return digits;
    }
}
//--leetcode submit region end(Prohibit modification and deletion)


    /**
     * for 循环，优化：
     * 从末尾开始循环；
     * 如果当前是9，则将当前位置为 0，并继续下一轮循环。否则，当前位加 1 后直接返回结果。
     */
//--leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;
            for (int i = digits.length-1; i >=0 ; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] ++;
                    return digits;
                }
            }

            int[] tmp = new int[digits.length +1];
            tmp[0] = 1;
            return tmp;
        }
    }
//--leetcode submit region end(Prohibit modification and deletion)


}