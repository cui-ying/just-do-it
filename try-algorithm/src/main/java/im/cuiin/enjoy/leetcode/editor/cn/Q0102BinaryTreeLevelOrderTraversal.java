/*
 * [102]二叉树的层序遍历
 *
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// 👍 1090 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.*;

/**
 * @author cuiin
 * @since 2021-11-19 09:10:37
 */
public class Q0102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q0102BinaryTreeLevelOrderTraversal().new Solution();
    }

    /* DFS 递归 */
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levelValList = new ArrayList<>();
            deal(levelValList, root, 0);
            return levelValList;
        }

        private void deal(List<List<Integer>> levelValList, TreeNode node, int level) {
            if (node == null) {
                return;
            }

            if (level >= levelValList.size()) {
                ArrayList<Integer> tmp = new ArrayList<>();
                levelValList.add(tmp);
            }

            List<Integer> tmp = levelValList.get(level);

            tmp.add(node.val);

            deal(levelValList, node.left, level + 1);
            deal(levelValList, node.right, level + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /* DFS 遍历 */
}