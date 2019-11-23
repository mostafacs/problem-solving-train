package com.solution.codility.arrays;

import java.util.HashSet;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 9;  A[1] = 3;  A[2] = 9;
        A[3] = 3;  A[4] = 9;  A[5] = 7;
        A[6] = 9;
        new OddOccurrencesInArray().solution(A);
    }

    public int solution(int[] A) {
        HashSet<Integer> numbers = new HashSet();
        for(int i=0; i<A.length; i++){
            if(numbers.contains(A[i])) {
                numbers.remove(A[i]);
            } else {
                numbers.add(A[i]);
            }
        }
        return numbers.iterator().next();
    }

}
