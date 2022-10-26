package com.leetcode.math;

import java.util.Stack;

/**
 * @Author Mostafa
 * On 10/26/22
 */
public class ReversePolishNotation {

    /*
    Input
["3","11","5","+","-"]
Output
13
Expected
-13
    */

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }


    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();
        for(String token : tokens) {
            switch(token) {
                case "+":

                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first+second);

                    break;
                case "-":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first-second);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":

                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);

                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }
}
