package com.solution.codility.countingelements;

import com.solution.utils.Utils;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 * Trick is not loop over counters and not set array with values every time A[k] = N+1 . Efficient solution is to cache minimum to set after update the counters.
 */
public class MaxCounters {

    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 3;
        A[1] = 4;
        A[2] = 4;
        A[3] = 6;
        A[4] = 1;
        A[5] = 4;
        A[6] = 4;
        Utils.printArray(new MaxCounters().solution(5, A));
    }

    public int[] solution(int N, int[] A) {

        int[] counters = new int[N];
        int max = 0, min = 0;


        for (int k = 0; k < A.length; k++) {

            int value = A[k]-1;
            if( value < N) {

                int actualValue = counters[value] < min  ? min : counters[value];
                counters[value] = actualValue + 1;
                if( counters[value] > max ) max = counters[value];

            } else  if(value == N) {
                min = max;
            }

            Utils.printArray(counters);

        }

        for (int i = 0; i < N; i++)  if(counters[i] < min) counters[i] = min;
        return counters;
    }


}
