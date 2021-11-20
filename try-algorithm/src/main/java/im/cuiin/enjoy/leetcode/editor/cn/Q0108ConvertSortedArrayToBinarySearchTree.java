/*
 * [108]将有序数组转换为二叉搜索树
 *
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
// 👍 870 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author cuiin
 * @since 2021-11-20 08:30:20
 */
public class Q0108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q0108ConvertSortedArrayToBinarySearchTree().new Solution();
    }

    /* 二分 + 递归 */
//--leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums, start, mid -1);
        root.right = buildTree(nums, mid + 1, end);

        return root;
    }
}
//--leetcode submit region end(Prohibit modification and deletion)


    /* 二分 + 遍历 */
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            Stack<TreeNode> nodeStack = new Stack<>();

            Stack<Integer> idxStack = new Stack<>();
            idxStack.push(0);
            idxStack.push(nums.length - 1);

            TreeNode root = null;

            while (!idxStack.isEmpty()) {
                Integer end = idxStack.pop();
                Integer start = idxStack.pop();
                TreeNode tmpRoot = null;
                if (!nodeStack.isEmpty()) {
                    tmpRoot = nodeStack.pop();
                }

                if (start > end) {
                    continue;
                }

                int mid = (start + end) >> 1;
                TreeNode node = new TreeNode(nums[mid]);
                if (tmpRoot != null) {
                    if (tmpRoot.val > node.val) {
                        tmpRoot.left = node;
                    } else {
                        tmpRoot.right = node;
                    }
                } else {
                    root = node;
                }

                idxStack.push(start);
                idxStack.push(mid - 1);
                nodeStack.push(node);

                idxStack.push(mid + 1);
                idxStack.push(end);
                nodeStack.push(node);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}