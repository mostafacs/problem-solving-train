package com.leetcode.tree;

import java.util.LinkedList;

/**
 * @author Mostafa
 */
public class JumpGame {


    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int index = 0;
        int steps = nums[0];
        do {
            if(nums[index] == 0) {
                for(int i=index+1; i < nums.length; i++) {
                    if(nums[i] == 0) index++;
                    else { return false; }
                }
            }
            index += nums[index];

        } while(index < nums.length-1);

        return index >= nums.length-1;
    }

    public static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[] {3,2,1,0,4}));
        new LinkedList<>().remove(new Object());
    }
}
