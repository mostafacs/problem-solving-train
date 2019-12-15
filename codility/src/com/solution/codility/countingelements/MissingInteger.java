package com.solution.codility.countingelements;

import java.util.HashSet;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
public class MissingInteger {

    public static void main(String[] args) {
        int[] A = new int[] {1, 3, 6, 4, 1, 2};
        System.out.println(new MissingInteger().solution(A));

        A = new int[] {1, 2, 3};
        System.out.println(new MissingInteger().solution(A));

        A = new int[] {-1, -2};
        System.out.println(new MissingInteger().solution(A));
    }


    public int solution(int[] A) {

        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                set.add(A[i]);
                if(A[i] > max) max = A[i];
            }
        }

        if(set.size() == 0 ) return 1;

        for (int i = 1; i < max+1; i++) {
            if(!set.contains(i)) return  i;
        }
        return max+1;
    }



}
