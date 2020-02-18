package com.solution.codility.sorting;

public class Triangle {

    public static void main (String[] args) {
        int[] A = new int[6];
        A[0] = 10;    A[1] = 2;    A[2] = 5;
        A[3] = 1;     A[4] = 8;    A[5] = 20;
        
        System.out.println(new Triangle().solution(A));
    }

    public int solution(int[] A) {
        for (int P = 0; P < A.length; P++) {
            if(A[P] <= 0) continue;
            for (int Q = P+1; Q < A.length; Q++) {
                if(A[Q] <= 0) continue;
                for (int R = Q+1; R < A.length; R++) {
                    if(A[R] <= 0) continue;
                    long v1 = (long) A[P] + (long) A[Q];
                    if( v1 > A[R] ) {
                        long v2 = (long) A[Q] + (long) A[R];
                        if( v2 > A[P]) {
                            long v3 = (long) A[R] + (long) A[P];
                            if( v3 > A[Q] ) {
                               return 1;
                           }
                        }
                    }

                }
            }
        }

        return 0;
    }


/*    public int solution2(int[] A1) {

        int[] A2 = new int[A1.length];
        int[] A3 = new int[A1.length];

        for (int i = 0; i < A1.length; i++) {
            A2[i] = A1[i];
        }
    }*/
}
