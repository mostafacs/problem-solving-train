package com.solution.codility.countingelements;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
public class FrogRiverOne {

    public static void main(String[] args) {
        int[] A = new int[8];
        A[0] = 1;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4] = 2;
        A[5] = 3;
        A[6] = 5;
        A[7] = 4;
        System.out.println(new FrogRiverOne().solution(5, A));
    }

    public int solution(int X, int[] A) {

        int[] positions = new int[X];
        for (int i = 0; i < positions.length; i++)  positions[i] = Integer.MAX_VALUE;

        for (int second = 0; second < A.length; second++) {

            int position = A[second] -1;
            if ( position < X && positions[position] > second) {
                positions[position] = second;
            }
        }

        int maxResult = max(positions);
        if(maxResult == Integer.MAX_VALUE) return -1;
        return maxResult;
    }

    int max(int[] A) {
        int max =  -1;
        for (int i = 0; i < A.length; i++) {
            max = A[i] >  max ? A[i] : max;
        }
        return max;
    }

}
