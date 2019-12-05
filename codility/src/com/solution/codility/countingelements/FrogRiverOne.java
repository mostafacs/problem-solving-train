package com.solution.codility.countingelements;

import java.util.HashMap;
import java.util.Map;

public class FrogRiverOne {

    public static void main(String[] args) {
        int[] A = new int[7];
        A[0] = 2;
        A[1] = 3;
        A[2] = 8;
        A[3] = 4;
        A[4] = 5;
        A[5] = 6;
        A[6] = 7;
        System.out.println(new PermCheck().solution(A));
    }

    public int solution(int[] A) {

        Map<Integer, Integer> counts = new HashMap<>();
        int validSum = 0;
        int inputSum = 0;
        for (int i = 0; i < A.length; i++) {
            validSum += i +1;
            inputSum += A[i];
            if(counts.containsKey(A[i])) counts.put(A[i], counts.get(A[i])+1);
            else counts.put(A[i], 1);
        }

        if(validSum != inputSum) return 0;
        for (Integer key: counts.keySet()) {
            if(counts.get(key) != 1) return 0;
        }
        return 1;
    }

}
