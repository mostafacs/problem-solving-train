package com.solution.codejam.c2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T ; t++) {

            char[] tldr = in.next().toCharArray();
            List<Integer> values =new ArrayList<>();
            for (int i = 0; i < tldr.length; i++) {
                values.add(Character.getNumericValue(tldr[i]));
            }

            int pindex= 0, vindex=0, openCount=0;
            boolean opening = true;
            StringBuilder str = new StringBuilder();
            do {

                if(values.size() > vindex && values.get(vindex) == pindex) {

                    str.append(values.get(vindex));
                    if(values.size() > vindex+1) {
                        opening = values.get(vindex) < values.get(vindex+1);
                    } else {
                        opening = false;
                    }
                    vindex++;

                } else {
                    if(opening) {
                        str.append('(');
                        openCount++;
                        pindex++;
                    }
                    else {
                        str.append(')');
                        openCount--;
                        if(openCount==0) opening=true;
                        pindex--;
                    }
                }

                //System.out.println(vindex +" - "+ pindex +"="+str);

            } while (vindex < values.size() || pindex > 0);

            System.out.println(String.format("Case #%d: %s", t, str.toString()));
        }

        in.close();
    }


}
