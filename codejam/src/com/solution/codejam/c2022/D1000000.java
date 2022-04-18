package com.solution.codejam.c2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Mostafa
 */
public class D1000000 {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int n = in.nextInt();
            Map<Integer, Integer> dices = new TreeMap<>();
           // int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
//                if(s < min) {
//                    min = s;
//                }
//                if(s > max) {
//                    max = s;
//                }
                if(dices.containsKey(s)) {
                    dices.put(s, dices.get(s)+1);
                }else {
                    dices.put(s, 1);
                }
            }

            int possible = 0;
            for(int dice : dices.keySet()) {
                int count = dices.get(dice);
                if(possible < dice) {
                    if (count <= dice) {
                        if(possible + count < dice) {
                            possible += count;
                        } else {
                            possible += dice - possible;
                        }
                    } else {
                        possible += dice;
                    }
                }
            }

            System.out.println("Case #"+t+": "+possible);


        }
        in.close();
    }

}
