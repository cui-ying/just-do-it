package im.cuiin.enjoy.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class Q0189RotateArrayTest {
    @Test
    public void test() {
        Q0189RotateArray.Solution solution = new Q0189RotateArray().new Solution();
//        Q0189RotateArray.Solution2 solution = new Q0189RotateArray().new Solution2();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
        Assert.assertEquals("expect 5, but not!", 5, nums[0]);
        Assert.assertEquals("expect 5, but not!", 4, nums[nums.length-1]);
    }
}