package com.solution.codejam.c2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Mostafa
 */
public class PunchedCards {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int r = in.nextInt();
            int c = in.nextInt();

            System.out.println("Case #"+ t +":");

            for (int i = 0; i <= r * 2; i++) {
                for (int j = 0; j <= c * 2; j++) {
                    if (i < 2 && j < 2) {
                        System.out.print(".");
                    } else {

                        if (i % 2 == 0) {
                            if (j % 2 == 0) {
                                System.out.print("+");
                            } else {
                                System.out.print("-");
                            }
                        } else {
                            if (j % 2 == 0) {
                                System.out.print("|");
                            } else {
                                System.out.print(".");
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
        in.close();
    }
}
