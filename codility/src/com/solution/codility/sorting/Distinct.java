package com.solution.codility.sorting;

import java.util.HashSet;

public class Distinct {

    public static void main (String[] args) {
        int[] A = new int[6];

        A[0] = 2;    A[1] = 1;    A[2] = 1;
        A[3] = 2;    A[4] = 3;    A[5] = 1;

        System.out.println(new Distinct().solution(A));
    }

    public int solution(int[] A) {
        HashSet set = new HashSet();
        for (int i: A) {
            set.add(i);
        }
        return set.size();
    }
}
