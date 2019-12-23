package com.solution.codility.prefixsum;

import com.solution.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {

    public static void main(String[] args) {
        int[] P = new int[3];
        int[] Q = new int[3];
        P[0] = 2;    Q[0] = 4;
        P[1] = 5;    Q[1] = 5;
        P[2] = 0;    Q[2] = 6;

        String S = "CAGCCTA";
        Utils.printArray(new GenomicRangeQuery().solution(S, P, Q));
    }

    public int[] solution(String S, int[] P, int [] Q) {
        
        //char[] SC = S.toCharArray();
        Map<Character, Integer> impactFactors = new HashMap<>();
        impactFactors.put('A', 1);
        impactFactors.put('C', 2);
        impactFactors.put('G', 3);
        impactFactors.put('T', 4);

        int[] SC = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            SC[i] = impactFactors.get(S.charAt(i));
        }

        int[] result = new int[Q.length];

        for (int i = 0; i < P.length; i++) {

            int PI = P[i], QI = Q[i];

            int min = 4;
            for (int j = PI; j <= QI; j++) {

                if(SC[j] == 1) {
                    result[i] = 1;
                    break;
                }

                // int cif = impactFactors.get(SC[j]);
                if( SC[j]  < min) {
                    result[i] = SC[j];
                    min = SC[j];
                }

            }

            if(result[i] == 0) result[i] = 4;

        }

        return result;
        
        
    }
}
