package im.cuiin.enjoy.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

public class Q0122BestTimeToBuyAndSellStockIiTest {
    @Test
    public void test() {
        Q0122BestTimeToBuyAndSellStockIi.Solution solution = new Q0122BestTimeToBuyAndSellStockIi().new Solution();
        Assert.assertEquals("7,1,5,3,6,4 expect 7, but not!", 7, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals("1,2,3,4,5 expect 4, but not!", 4, solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals("7,6,4,3,1 expect 0, but not!", 0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}