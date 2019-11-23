package com.solution.codility.timecomplexity;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class ForgJmp {

    public static void main(String[] args) {
        System.out.println(new ForgJmp().solution(5, 5000, 12));
    }

    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        int jc = distance / D;
        if(distance % D != 0) {
            jc++; //only add extra jump if remainder exists
        }
        return jc;
    }
}
