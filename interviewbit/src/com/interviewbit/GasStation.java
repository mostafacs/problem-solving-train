package com.interviewbit;

import java.util.*;

/**
 * @Author Mostafa
 * On 10/21/22
 */
public class GasStation {

    public static void main(String[] args) {
        // A = [1, 2]
        //B = [2, 1]
        System.out.println(canCompleteCircuit(new int[] {3, 1, 1}, new int[]{1, 2, 2}));
        System.out.println(canCompleteCircuit(new int[] {2, 2, 2, 7, 7}, new int[]{4, 4, 4, 4, 4}));

    }


    public static int canCompleteCircuit(final int[] A, final int[] B) {

        int start = 0;
        int tank = 0;
        int total = 0;
        for(int i=0; i<A.length; i++) {
            total += A[i] - B[i];
            tank += A[i] - B[i];
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
