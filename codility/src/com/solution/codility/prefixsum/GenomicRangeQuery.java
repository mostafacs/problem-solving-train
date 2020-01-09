package com.solution.codility.prefixsum;

import com.solution.utils.Utils;

/**
 * @Author Mostafa
 * Lesson https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 * creating prefix sum of count indexer for fast query results and use subtraction to find if Nucleotides exists if it's count > 0
 */
public class GenomicRangeQuery {

    public static void main(String[] args) {
        int[] P = new int[3];
        int[] Q = new int[3];
        P[0] = 0;    Q[0] = 0;
        P[1] = 0;    Q[1] = 1;
        P[2] = 1;    Q[2] = 1;

        String S = "AC";
        Utils.printArray(new GenomicRangeQuery().solution(S, P, Q));
    }

    /*
   The following issues have been detected: wrong answers.

     For example, for the input ('AC', [0, 0, 1], [0, 1, 1]) the solution returned a wrong answer (got [1, 2, 2] expected [1, 1, 2]).
   */
    public int[] solution(String S, int[] P, int [] Q) {

       int[][] indexer = new int[S.length()+1][4];

        for (int i = 0; i < S.length(); i++) {

            short a=0, c=0, g=0, t=0;
            switch (S.charAt(i)) {
                case 'A':
                    a = 1;
                    break;
                case 'C':
                   c = 1;
                    break;
                case 'G':
                   g = 1;
                    break;
                case 'T':
                    t = 1;
                    break;
            }

            indexer[i+1][0] = indexer[i][0] + a;
            indexer[i+1][1] = indexer[i][1] + c;
            indexer[i+1][2] = indexer[i][2] + g;
            indexer[i+1][3] = indexer[i][3] + t;

        }

        int[] result = new int[Q.length];

        for (int i = 0; i < P.length; i++) {

            int PI = P[i], QI = Q[i] + 1;
//            System.out.println(indexer[QI][0] - indexer[PI][0]);
//            System.out.println(indexer[QI][1] - indexer[PI][1]);
//            System.out.println(indexer[QI][2] - indexer[PI][2]);
//            System.out.println(indexer[QI][3] - indexer[PI][3]);
//            System.out.println("-------------------");



            if( (indexer[QI][0] - indexer[PI][0]) > 0 ) result[i] = 1;
            else if( (indexer[QI][1] - indexer[PI][1]) > 0 ) result[i] = 2;
            else if( (indexer[QI][2] - indexer[PI][2]) > 0 ) result[i] = 3;
            else result[i] = 4;
//            System.out.println("RESULT = "+result[i]);
//            System.out.println(">>>>>>>>>>>>>>>>>>>");

        }

        return result;
    }
}
