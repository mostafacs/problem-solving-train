package com.solution.codility.prefixsum;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 * I'm not fully understand this problem.
 */
public class MinAvgTwoSlice {
    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 4;
        A[1] = 2;
        A[2] = 2;
        A[3] = 5;
        A[4] = 1;
        A[5] = 5;
        A[6] = 8;

        System.out.println(new MinAvgTwoSlice().solution(A));
    }

    public int solution(int[] A) {

        int minIndex = 0;
        double minAvg = Double.MAX_VALUE;


        for (int i = 1; i < A.length; i++) {
            Integer count = 2;
            double avg = A[i] + A[i-1];
            for (int j = i+1; j < A.length; j++) {
                if(A[j] <= 0) {
                    System.out.println(A[j]);
                    count++;
                    double newAvg =  avg + A[j];

                } else {
                    break;
                }
            }

             avg = avg /  count.doubleValue();

            if(avg < minAvg) {
                minAvg = avg;
                minIndex = i -1;
            }
        }
        System.out.println("RESult = "+ minIndex);
        return minIndex;
    }
}
