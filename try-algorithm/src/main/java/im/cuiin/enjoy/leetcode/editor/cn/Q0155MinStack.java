/*
 * [155]最小栈
 *
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 👍 1099 👎 0

 */

package im.cuiin.enjoy.leetcode.editor.cn;

import java.util.Stack;

/**
 * [155]最小栈
 * @author cuiin @ 2021-12-01 09:09:44
 */
public class Q0155MinStack {
    public static void main(String[] args) {
        MinStack solution = new Q0155MinStack().new MinStack();
    }

    /**
     * <b>双栈</b>
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        //栈1存放的是需要压栈的值
        Stack<Integer> stack1 = new Stack<>();
        //栈2存放的是最小值
        Stack<Integer> stack2 = new Stack<>();

        public void push(int x) {
            stack1.push(x);
            if (stack2.empty() || x <= getMin())
                stack2.push(x);
        }

        public void pop() {
            //如果出栈的值等于最小值，说明栈中的最小值
            //已经出栈了，因为stack2中的栈顶元素存放的
            //就是最小值，所以stack2栈顶元素也要出栈
            if (stack1.pop() == getMin())
                stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}