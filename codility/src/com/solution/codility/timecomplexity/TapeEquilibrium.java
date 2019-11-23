package com.solution.codility.timecomplexity;


/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {


    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 1;
        A[2] = 2;
        A[3] = 4;
        A[4] = 3;
        System.out.println(new TapeEquilibrium().solution(A));
    }

    public int solution(int[] A) {

        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
        }

        int left = totalSum;
        int right = 0;

        int mindiff = Integer.MAX_VALUE;

        for (int i = 0; i < A.length-1; i++) {
            left -= A[i];
            right += A[i];
            int diff = absoluteDiff(left, right);
            mindiff = Integer.min(diff, mindiff);
        }

        return mindiff;
    }

    public int absoluteDiff(int a, int b) {

        int diff = a - b;
        // System.out.println(String.format("%d - %d = %d", a, b, diff));
        return diff < 0 ? diff*-1 : diff;
    }


}
