package com.solution.codility.prefixsum;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
 */
public class PassingCars {


    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 0;
        A[1] = 1;
        A[2] = 0;
        A[3] = 1;
        A[4] = 1;

        System.out.println(new PassingCars().solution(A));
    }

    public int solution(int[] A) {

        int count = 0;
        int increaseBy = 0;
        for (int i = 0; i < A.length; i++) {

            if(A[i] == 0) increaseBy ++;
            else if(A[i] == 1) count += increaseBy;
            if(count > 1000000000) return  -1;

        }

        return count;
    }
}
