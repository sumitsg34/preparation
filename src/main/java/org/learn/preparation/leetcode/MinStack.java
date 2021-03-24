package org.learn.preparation.leetcode;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    class Pair {
        int num;
        int lastMin;

        Pair(int num, int lastMin) {
            this.num = num;
            this.lastMin = lastMin;
        }
    }

    List<Pair> stack = new ArrayList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (stack.size() > 0) {
            Pair last = stack.get(stack.size() - 1);
            if (x > last.lastMin) {
                stack.add(new Pair(x, last.lastMin));
                return;
            }
        }
        stack.add(new Pair(x, x));
    }

    public void pop() {
        Pair pair = stack.remove(stack.size() - 1);
        System.out.println("removed:" + pair.num);
    }

    public int top() {
        return stack.get(stack.size() - 1).num;
    }

    public int getMin() {
        return stack.get(stack.size() - 1).lastMin;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println("min:" + minStack.getMin());
        minStack.pop();
        System.out.println("min:" + minStack.getMin());

    }

}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
