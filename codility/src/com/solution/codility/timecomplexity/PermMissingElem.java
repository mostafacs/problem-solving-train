package com.solution.codility.timecomplexity;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class PermMissingElem {

    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 2;
        A[1] = 3;
        A[2] = 8;
        A[3] = 4;
        A[4] = 5;
        A[5] = 6;
        A[6] = 7;
        System.out.println(new PermMissingElem().solution(A));
    }

    public int solution(int[] A) {

        boolean[] flags = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            int value = A[i] - 1;
            if( value >= A.length) continue;
            flags[value] = true;
        }

        for (int i = 0; i < flags.length; i++) {
            if(!flags[i]) return i+1;
        }
        // N+1
        return flags.length + 1;
    }

    public int solution2(int[] A) {

        int validSum = 0;
        int existSum = 0;
        for (int i = 0; i < A.length; i++) {
            validSum += i+1;
            existSum += A[i];
        }
        validSum += A.length + 1;
        return validSum - existSum;
    }




}
