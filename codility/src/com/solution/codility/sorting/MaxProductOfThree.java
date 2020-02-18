package com.solution.codility.sorting;

import java.util.Arrays;


/**
 * notes detection of negative ( value <= 0 )
 * Solution idea is simple. Check negative combinations after sorting the array
 */
public class MaxProductOfThree {

    public static void main (String[] args) {
        int[] A = new int[6];

        A[0] = -3;
        A[1] = 1;
        A[2] = 2;
        A[3] = -2;
        A[4] = 5;
        A[5] = 6;

        System.out.println(new MaxProductOfThree().solution(A));
    }


    public int solution(int[] A) {
        Arrays.sort(A);
        int[] result = new int[5];

        if(A.length == 3) return  A[A.length-1] * A[A.length-2] * A[A.length-3];
        result[0] = A[0] * A[1] * A[A.length-1];
        result[1] = A[0] * A[2] * A[A.length-1];
        result[2] = A[1] * A[1] * A[A.length-1];
        result[3] = A[1] * A[2] * A[A.length-1];
        result[4] = A[A.length-1] * A[A.length-2] * A[A.length-3];

        return  max(result);
    }

    public int max(int arr[])
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    // brute force
    public int bruteForcesolution(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length-2; i++) {
            for (int j = i+1; j < A.length-1; j++) {
                for (int k = j+1; k < A.length; k++) {
                    int temp = A[i]  * A[j] * A[k];
                    if(temp > max) {
                        max = temp;
                    }
                }
            }
        }

        return max;
    }
}
