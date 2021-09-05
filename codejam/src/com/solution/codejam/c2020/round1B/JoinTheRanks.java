package com.solution.codejam.c2020.round1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JoinTheRanks {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {

            int r = in.nextInt();
            int s = in.nextInt();

            int minItr = (s-1) * (r-1);
            System.out.println(minItr);
            for (int i = 1; i < s; i++) {
                for (int j = r; j > r-1; j--) {
                    int a = i*j;
                    int b = j-1;
                    System.out.println(i*j +"-"+ (j-1));
                    for (int k = 0; k < r-2; k++) {
                        System.out.println(--a +"-"+ --b);

                    }
                }
            }


        }
    }


}
