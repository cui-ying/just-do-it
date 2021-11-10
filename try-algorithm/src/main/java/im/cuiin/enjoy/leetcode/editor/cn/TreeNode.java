package im.cuiin.enjoy.leetcode.editor.cn;

/**
 * 二叉树
 *
 * @author cuiin on 2021/11/10 9:16
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}