/*
 * [101]对称二叉树
 *
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// 👍 1602 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author cuiin
 * @since 2021-11-15 09:04:06
 */
public class Q0101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Q0101SymmetricTree().new Solution();
    }

    /* 按层递归 */
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        return isSymmetric(stack);
    }

    private boolean isSymmetric(Stack<TreeNode> stack) {
        /* 空栈或奇数个数的栈处理 */
        if (stack.size() == 0) {
            return true;
        } else if (stack.size() % 2 != 0) {
            return false;
        }

        Stack<TreeNode> tmpStack = new Stack<>();

        /* 对半分，弹出到临时栈之后，两个栈的顺序理应一致，否则就不是对称的。 */
        int half = stack.size() / 2;
        for (int i = 0; i < half; i++) {
            TreeNode tmp = stack.pop();
            tmpStack.push(tmp);
        }

        /* 元素比较 */
        // 是否继续下一层。
        boolean goon = false;
        for (int i = 0; i < stack.size(); i++) {
            TreeNode tmp = stack.get(i);
            TreeNode tmp2 = tmpStack.get(i);

            if (tmp != null && tmp2 == null) {
                return false;
            } else if (tmp == null && tmp2 != null) {
                return false;
            } else if (tmp != null) {
                if (tmp.val != tmp2.val) {
                    return false;
                } else {
                    goon = true;
                }
            }
        }

        /* 当该层所有元素都为 null 时，就不用往下迭代了 */
        if (!goon) {
            return true;
        }

        /* 当前层元素对称，则反序栈元素，之后构造下一层元素栈 */
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }

        Stack<TreeNode> nextStack = new Stack<>();
        while (!tmpStack.isEmpty()) {
            TreeNode tmp = tmpStack.pop();
            if (tmp != null) {
                nextStack.push(tmp.left);
                nextStack.push(tmp.right);
            }
        }
        return isSymmetric(nextStack);
    }


}
//--leetcode submit region end(Prohibit modification and deletion)

}