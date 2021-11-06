/*
 * [234]回文链表
 *
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// 👍 1166 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author cuiin
 * @since 2021-11-06 09:06:51
 */
public class Q0234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q0234PalindromeLinkedList().new Solution();
    }


    /* 递归：优化 */
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        private ListNode tmp;
        public boolean isPalindrome(ListNode head) {
            tmp = head;
            return equals(head);
        }

        private boolean equals(ListNode n2) {
            if (n2 == null) {
                return true;
            } else {
                boolean eq2 = equals(n2.next) && (tmp.val == n2.val);
                tmp = tmp.next;
                return eq2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}