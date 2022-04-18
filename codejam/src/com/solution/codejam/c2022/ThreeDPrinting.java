package com.solution.codejam.c2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Mostafa
 */
public class ThreeDPrinting {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        int max = 1000000;
        for (int t = 1; t <= T; t++) {

            int[] result = {0, 0, 0, 0};
            int[][] colors= new int[3][4];
            for (int i = 0; i < 3; i++) {
                int c = in.nextInt();
                int m = in.nextInt();
                int y = in.nextInt();
                int k = in.nextInt();
                colors[i] = new int[]{c, m, y, k};
            }


            // int accumulator = 0;
//            outer: for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 4; c++) {
                    result[c] += min(colors[0][c], colors[1][c], colors[2][c]);
            }
            long total = sum(result);
            if(total == max) {
                printSolution(t, result);
            }
            else if(total > max) {
                long toRemove = total - max;
                for (int i = 3; i > -1; i--) {
                    int current = result[i];
                    if(current >= toRemove) {
                        result[i] = current - (int)toRemove;
                        break;
                    }
                    else {
                        toRemove -= result[i];
                        result[i] = 0;
                    }
                }
                printSolution(t, result);
            }
            else {
                System.out.println("Case #"+ t +": IMPOSSIBLE");
            }
        }
        in.close();
    }

    public static int min(int ... numbers) {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if(num < min) {
                min = num;
            }
        }
        return min;
    }

    public static long sum(int ... numbers) {
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static void printSolution(int t, int[] values) {
        System.out.println("Case #"+ t +": "+ values[0] +" "+values[1]+ " "+ values[2]+" "+values[3]);
    }

}
