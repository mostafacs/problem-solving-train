package com.solution.codejam.c2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Vestigium {


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T ; t++) {

            int N = in.nextInt();
            Map<Integer, HashSet<Integer>> rows = new HashMap();
            Map<Integer, HashSet<Integer>> cols = new HashMap();

            HashSet repeatedRows = new HashSet();
            HashSet repeatedCols = new HashSet();
            int trace = 0;
            for (int i = 0; i < N; i++) {
                rows.put(i, new HashSet());
                for (int j = 0; j < N; j++) {
                    Integer cellValue = in.nextInt();
                    if (rows.get(i).contains(cellValue)) {
                        repeatedRows.add(i);
                    }else {
                        rows.get(i).add(cellValue);
                    }

                    if (!cols.containsKey(j)) {
                        HashSet set = new HashSet();
                        set.add(cellValue);
                        cols.put(j, set);
                    } else {
                        if (cols.get(j).contains(cellValue)) {
                            repeatedCols.add(j);
                        } else {
                            cols.get(j).add(cellValue);
                        }
                    }

                    if (i == j) trace += cellValue;


                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, trace, repeatedRows.size(), repeatedCols.size()));
        }

        in.close();

    }
}
