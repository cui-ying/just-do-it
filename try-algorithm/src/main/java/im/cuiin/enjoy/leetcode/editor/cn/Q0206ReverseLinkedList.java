/*
 * [206]反转链表
 *
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// 👍 2054 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author cuiin
 * @since 2021-11-02 09:10:50
 */
public class Q0206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new Q0206ReverseLinkedList().new Solution();
    }

    /* 迭代 */
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode current = head;
        ListNode last = head.next;

        while (last != null) {
            current.next = pre;
            pre = current;
            current = last;
            last = last.next;
        }
        current.next = pre;

        return current;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}