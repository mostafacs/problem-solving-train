package com.solution.codejam;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class DatBae {

    public static void main(String[] args) throws IOException {

        OutputStream outputStream = System.out;
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            int N = in.nextInt();
            int B = in.nextInt();
            int F = in.nextInt();

            char[][] queries = generateQueries(N);
            char[][] results = new char[5][N-B];
            for (int q = 0; q < 5; q++) {

                System.out.println(queries[q]);
                System.out.flush();

                results[q] = in.nextLine().toCharArray();
            }


            for (int j = 0; j < N-B; j++) {
                for (int k = 0; k < 5; k++) {

                }
            }

        }






//        System.out.println(5&1);
//        System.out.println(2&1);
//        System.out.println(4&1);
//        System.out.println(3&1);
    }


    private static char[][] generateQueries(int n) {

        char[][] qs = new char[5][n];

        int swap = 1;
        for (int i = 0 ;i < 5; i++) {

            boolean zero = true;;
            for (int j = 1; j <= n; j++) {
                qs[i][j-1] = zero ? '0' : '1';
                if( j % swap == 0) zero = !zero;
            }
            swap *= 2;
            System.out.println(String.valueOf(qs[i]));
        }

        return qs;

    }
}
