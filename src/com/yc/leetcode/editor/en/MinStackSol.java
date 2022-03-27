//Design a stack that supports push, pop, top, and retrieving the minimum 
//element in constant time. 
//
// Implement the MinStack class: 
//
// 
// MinStack() initializes the stack object. 
// void push(int val) pushes the element val onto the stack. 
// void pop() removes the element on the top of the stack. 
// int top() gets the top element of the stack. 
// int getMin() retrieves the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// Methods pop, top and getMin operations will always be called on non-empty 
//stacks. 
// At most 3 * 10⁴ calls will be made to push, pop, top, and getMin. 
// 
// Related Topics Stack Design 👍 7549 👎 593


package com.yc.leetcode.editor.en;
public class MinStackSol{
    public void main(String[] args) {
        MinStack solution = new MinStack();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    private int pos;
    private int min;
    private int[] data;
    private final int size = 30000;
    public MinStack() {
        pos = -1;
        min = Integer.MAX_VALUE;
        data = new int[size];
    }
    
    public void push(int val) {
        if (val < min)
            min = val;
        pos++;
        data[pos] = val;
    }
    
    public void pop() {
        if (data[pos] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < pos; i++) {
                if (data[i] < min)
                    min = data[pos];
            }
        }
        if (pos > 0)
            pos--;
    }
    
    public int top() {
        return data[pos];
    }
    
    public int getMin() {
        return min;
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