/*
 * [350]两个数组的交集 II
 *
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// 👍 545 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;



/**
 * @author cuiin
 * @since 2021-09-04 18:41:47
 */
public class Q0350IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new Q0350IntersectionOfTwoArraysIi().new Solution();
    }

    /**
     * 排序后双指针遍历
     */
//--leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        java.util.Arrays.sort(nums1);
        java.util.Arrays.sort(nums2);

        java.util.Vector<Integer> rst = new java.util.Vector<>();
        int i =0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                rst.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] arr = new int[rst.size()];
        for (int k = 0; k < rst.size(); k++) {
            arr[k] = rst.get(k);
        }

        return arr;
    }
}
//--leetcode submit region end(Prohibit modification and deletion)

    /**
     * map 计数
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return new int[0];
            }

            java.util.Map<Integer, Integer> cache = new java.util.HashMap<>();

            for (int n : nums1) {
                Integer old = cache.get(n);
                if (old == null) {
                    cache.put(n, 1);
                } else {
                    cache.put(n, old +1 );
                }
            }

            java.util.Vector<Integer> rst = new java.util.Vector<>();
            for (int m : nums2) {
                Integer old = cache.get(m);
                if (old != null && old != 0) {
                    cache.put(m, old -1);
                    rst.add(m);
                }
            }

            int[] arr = new int[rst.size()];
            for (int k = 0; k < rst.size(); k++) {
                arr[k] = rst.get(k);
            }

            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}