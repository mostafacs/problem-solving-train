package com.solution.codejam.c2020.round1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    /*
    3 2
    3+1%2 = 0 ||||  2+1%2 = 1
    3 0
    3+1 %2 = 0 ||||| 0+1 %2 = 1
    * */
    public static void main(String[] args) {
//        System.out.println(polish(solve(2, 3), 2, 3));
//        System.out.println(polish(solve(-2, -3), -2, -3));
//        System.out.println(polish(solve(14, 17), 14, 17));
//        System.out.println(polish(solve(1, -1), 1, -1));
//
//        System.out.println(solve(3, 0));
//        System.out.println(solve(-1, 1));


        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        // x = y +1
        // x = y-1
        for (int t = 1; t <= T; t++) {

            int x = in.nextInt();
            int y = in.nextInt();

            String solution = solve(x, y);
            if(!solution.equals("IMPOSSIBLE")) {
                solution = polish(solution, x, y);
            }
            System.out.println("Case #" + t + ": "+solution);

        }

    }

    public static String polish(String path, int x, int y) {
        char[] result = path.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if(result[i] == 'N') {
                if (y<0) result[i] = 'S';
                continue;
            }
            if(result[i] == 'S') {
                if (y<0) result[i] = 'N';
                continue;
            }

            if(result[i] == 'E') {
                if (x<0) {
                    result[i] = 'W';
                }
                continue;
            }

            if(result[i] == 'W') {
                if (x<0) result[i] = 'E';
            }

        }
        return new String(result);

    }

    public static String solve(int x, int y) {
        //System.out.println(y%2);
        x = Math.abs(x); y = Math.abs(y);
        if(x%2 == 0 && y%2 == 0) return "IMPOSSIBLE";
        if(x%2 != 0 && y%2 != 0) return "IMPOSSIBLE";
//        int stepx = 0;
//        int stepy = 0;
        String result = "";
        if(x%2 > 0) {

            if(isOdd((x+y)/2)) {
                result += "E" ;
                x--;
            }
            else {
                result += "W" ;
                x++;
            }
        } else {
            if(isOdd((x+y)/2)) {
                result += "N";
                y--;
            }
            else {
                result += "S" ;
                y++;
            }
        }
        int exp = 1;
        while(x > 0 || y > 0) {
            //if(stepx == x && stepy == y) break;
            int step = (int) Math.pow(2, exp);
            int tempx = x-step;
            int tempy = y-step;

            int tempx2 = x+step;
            int tempy2 = y+step;

            if(tempx == 0) {
                x = 0;
                result += "E";
            }
            else if(tempy == 0) {
                y = 0;
                result += "N";
            }
            else {

                int nextStep = (int) Math.pow(2, exp+1);

                if(tempx > 0 && ( tempx == x || tempx % nextStep == 0 )) {
                    result += "E";
                    x = tempx;
                }
                else if (tempy > 0 && (tempy == y || tempy % nextStep == 0)){
                    result += "N";
                    y = tempy;
                }
                else if(tempx2 > 0 && (tempx2 == x || tempx2 % nextStep == 0)) {
                    result += "W";
                    y = tempx2;
                }
                else if (tempy2 > 0 && (tempy2 == y || tempy2 % nextStep == 0)){
                    result += "S";
                    y = tempy2;
                }
                else {
                    if(x == 0 && y==0) {
                        return result;
                    }
                    else
                        return "IMPOSSIBLE";
                }
            }

            exp ++;
            System.out.println(result);
        }
        //System.out.println(stepx +" - "+stepy);
        if(x == 0 && y==0) {
            return result;
        }
        return "IMPOSSIBLE";
    }

    public static boolean isOdd(int n) {
        return n%2 == 0 ? false : true;
    }

    static Double log(int x) {
        return Math.log(x) / Math.log(2);
    }

}
