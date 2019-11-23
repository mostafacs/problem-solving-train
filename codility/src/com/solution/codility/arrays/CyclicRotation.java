package com.solution.codility.arrays;

import com.solution.utils.Utils;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class CyclicRotation {
    public static void main(String[] args) {

        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        Utils.printArray(new CyclicRotation().solution(A, K));
    }

    public int[] solution(int[] A, int K) {

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int newIndex = (i+K) % A.length;
            result[newIndex] = A[i];
        }
        return result;
    }
}
