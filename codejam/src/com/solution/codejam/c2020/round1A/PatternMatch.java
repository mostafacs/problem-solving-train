package com.solution.codejam.c2020.round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mostafa
 * Solution idea:
 * Split prefix, meduims and suffixes in a separate strings
 * Note from max string result = 10 ^4 = 10,000 chars. and the max N=50 and max single line Length=100
 * that means if you forcely concatenate strings y will never reach the maximum 50x100 = 5000 < 10,000
 */
public class PatternMatch {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int N = in.nextInt();
            List<Pattern> patterns = new ArrayList<>();
            for (int i = 0; i < N+1; i++) {
                String pattern = in.nextLine();
                patterns.add(Pattern.build(pattern));
            }

            System.out.println("Case #"+t+": "+ solve(patterns) );

        }
    }

    static String solve(List<Pattern> patterns) {

        String prefixes = "";
        String meduims =  "";
        String suffixes = "";


        for(Pattern pattern : patterns) {


            /**
             * If restrictStart is false append to start at index
             */

            // have a prefix
            if(!pattern.startsWithAsterisk) {
                if(prefixes.length() == 0) {
                    prefixes = pattern.parts[0];
                }
                else {
                    if(!pattern.haveAsterisk) {
                        if( !(prefixes + meduims + suffixes).equals(pattern.text) ) {
                            return "*";
                        }
                        else
                            continue;
                    }

                    if(prefixes.length() >= pattern.parts[0].length()) {
                        if(!prefixes.startsWith(pattern.parts[0])) {
                            return "*";
                        }
                    } else {
                        if(!pattern.parts[0].startsWith(prefixes)) {
                            return "*";
                        }
                        else {
                            prefixes = pattern.parts[0];
                        }
                    }
                }
            }
            else {
                meduims += pattern.parts[0];
            }

            if(pattern.parts.length > 1) {
                int end = pattern.endsWithAsterisk ?  pattern.parts.length : pattern.parts.length-1;
                for (int i = 1; i < end; i++) {
                    meduims += pattern.parts[i];
                }
            }

            if(!pattern.endsWithAsterisk) {
                String currentSuffix = pattern.parts[pattern.parts.length-1];
                if(suffixes.length() == 0) {
                    suffixes = currentSuffix;
                }
                else {

                    if(suffixes.length() >= currentSuffix.length()) {
                        if(!suffixes.endsWith(currentSuffix)) {
                            return "*";
                        }
                    } else {
                        if(!currentSuffix.endsWith(suffixes)) {
                            return "*";
                        }
                        else {
                            suffixes = currentSuffix;
                        }
                    }
                }
            }

        }

        return prefixes + meduims + suffixes;
    }


    static class Pattern {

        String text;
        public String[] parts;
        public boolean startsWithAsterisk;
        public boolean endsWithAsterisk;
        public boolean haveAsterisk;

        static Pattern build(String v) {
            Pattern p = new Pattern();
            p.text = v;
            p.parts = v.split("\\*");
            p.startsWithAsterisk = v.startsWith("*");
            p.endsWithAsterisk = v.endsWith("*");
            p.haveAsterisk = p.startsWithAsterisk || p.endsWithAsterisk || p.parts.length > 1 ;
            return p;
        }
    }

}
