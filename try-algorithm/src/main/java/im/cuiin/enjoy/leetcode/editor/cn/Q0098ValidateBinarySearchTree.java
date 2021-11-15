/*
 * [98]验证二叉搜索树
 *
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// 👍 1296 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author cuiin
 * @since 2021-11-14 08:03:04
 */
public class Q0098ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Q0098ValidateBinarySearchTree().new Solution();
    }

    /* 递归 */
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max) {
        // 如果当前节点为空，则为有效二叉搜索树
        if (root == null) {
            return true;
        }

        // 当前节点在有效范围内
        if (root.val >= min && root.val <= max) {
            // 边界条件判断：当前节点若已经是最小整型值，则不能存在左子树了；若当前节点已经是最大整型值，则不能存在右子树了。
            if (root.val == Integer.MIN_VALUE && root.left != null) {
                return false;
            }
            if (root.val == Integer.MAX_VALUE && root.right != null) {
                return false;
            }

            // 符合条件的话，再递归下去
            return isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max);
        }
        return false;
    }
}
//--leetcode submit region end(Prohibit modification and deletion)

}