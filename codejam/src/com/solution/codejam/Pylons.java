package com.solution.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pylons {


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                HashMap<Integer, List<Integer>> rows = new HashMap();
                for (Integer i = 1; i <= r; i++) {
                    List<Integer> columns = new LinkedList();
                    rows.put(i, columns);
                    for (int j = 1; j <= c; j++) {
                        columns.add(j);
                    }
                }
                String result = solve(r, c, rows);
                System.out.println("Case #" + testNumber + ": " + (result == null ? "IMPOSSIBLE" : "POSSIBLE"));
                if (result != null) {
                    System.out.println(result);
                }
            }
        }
    }

    public static String solve(int r, int c, HashMap<Integer, List<Integer>> data) {

        Integer ar = r / 2 + 1, ac = c / 2 + 1;
        boolean working = true;

        StringBuilder result = new StringBuilder();
        int rowDirection = 1;

        data.get(ar).remove(ac);

        while (working) {

            result.append(ar + " " + ac);
            result.append("\n");
//            data.get(ar).remove(ac);
//            if(data.get(ar).size() == 0) {
//                data.remove(ar);
//            }


            int loop = 0;
            Integer newr = ar + 1, newc = 0;

            while (loop != (r * c)) {


                newc++;
                if (newc > c) {
                    newr += rowDirection;
                    newc = 1;
                }

                if (newr < 1) {
                    newr = r;
                    rowDirection = -1;
                    newc = 0;
                    continue;
                } else if (newr > r) {
                    newr = 1;
                    rowDirection = 1;
                    newc = 0;
                    continue;
                }

                // System.out.println(newr + " - "+newc);
                loop++;


                if (!data.containsKey(newr) || !data.get(newr).contains(newc)) {
                    // System.out.println("Continue >>>>>>>>>>>>>>>>>>>>>>>");
                    continue;
                }

                // System.out.println( ac + " <> " + newc +" --- "+ ar +" <> "+newr);

                if (newr == ar || newc == ac || ((ar + 1) == newr && (ac - 1 == newc)) || ((ar + 1) == newr && (ac + 1 == newc)) ||
                        ((ar - 1) == newr && (ac + 1) == newc) || ((ar - 1) == newr && (ac - 1) == newc)) {
                    // System.out.println("X Continue...");
                    continue;
                }

                // System.out.println("newr = "+newr + " --- newc="+newc);
                data.get(newr).remove(newc);
                if (data.get(newr).size() == 0) {
                    data.remove(newr);
                }

                // System.out.println("break;;;");

                break;

            }
            //  System.out.println(loop);
            // System.out.println("ar = "+ar +"\n ac="+ac);
            if (data.size() == 0) {

                result.append(newr + " " + newc);
                result.append("\n");
                working = false;
            }


            if (ar.equals(newr) && ac.equals(newc) && data.size() > 0) {
//                System.out.println("xxxxxxxxxxx");
                // System.out.println(result);
                return null;
            }
            ar = newr;
            ac = newc;

        }


        if (data.size() > 0) {
            return null;
        }

        return result.toString();
    }

}
