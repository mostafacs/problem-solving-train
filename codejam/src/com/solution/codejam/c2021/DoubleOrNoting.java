package com.solution.codejam.c2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa
 */
public class DoubleOrNoting {


    public static void main(String[] args) {
        String S, E;
//        // 1110
//        String E= "10001"; // 1,3,1
//        String S = "111"; //      3
//
//        // 111000
//        //
//        if(E.equals(S)) {
//            System.out.println("0");
//            return;
//        }
//        else if(E.equals(0)) {
//
//        }

//        solve(E,S);
//        System.out.println("-----------------------------------");
//
//        E = "1011"; // 1,1,2
//        S = "111"; //      1
//        solve(E,S);
//        System.out.println("-----------------------------------");
////
////
//        E = "1010"; // 1,1,1,1   10100  1011
//        S = "1011"; //   1,1,2
//        solve(E,S);
//        System.out.println("-----------------------------------");
////
//
//        E = "11111111001011"; // 82112 1101100 // 10011 1100 11 00  // 2112
//        S = "1011";   // 112
//        solve(E,S);
//        System.out.println("-----------------------------------");
//
//
         E = "11";
         S = "1000";
        // 11 110  001 1 10 100 1000
        solve(E,S);

        System.out.println("-----------------------------------");
        E = "1111"; // 111100  // 11 //110 // 11000
        S = "1100";
        // 11 110  001 1 10 100 1000
        solve(E,S);

    }


    /**


     1111011011   1010
     0000100100   1010
     100100       1010
     11011       1010
     100   1010
     10   1010
     impossible


     10  10001
     10000
     11110
     Impossible


     Work here ...
      2  13
     111 1000
     11  1000 // 2,1   ---  1,3

     1000 11
     // 111 11100 11



     */

    // 110 2,1   1000 1,3
    public static Boolean isValid(List<Integer> eseq, List<Integer> sseq) {
        if(eseq.size() == 1 || sseq.size() == 1) return true;
        if(eseq.size() >= sseq.size()) {
            for (int i = 1; i < sseq.size(); i++) {
                if(eseq.get(eseq.size()-i) != sseq.get(sseq.size()-i) ) {
                    return false;
                }
            }
        }
        else if(sseq.size() >= eseq.size()){
            for (int i = 1; i < eseq.size(); i++) {
                if(eseq.get(eseq.size()-i) != sseq.get(sseq.size()-i) ) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void solve(String E, String S) {
        List<Integer> eSeq = findCountersSeq(E);
        printArray(eSeq);
        List<Integer> sSeq = findCountersSeq(S);
        printArray(sSeq);
        System.out.println("<<<< Target >>>>>> "+S);
        int operations = 0;
        while (!E.equals(S)) {
            if (   (
                    E.endsWith("1") && eSeq.size() > 1
            )
                    || (  eSeq.get(eSeq.size()-1) ==  sSeq.get(sSeq.size()-1) &&  sSeq.size() == 1 )
                    || ( eSeq.size() == sSeq.size() && eSeq.get(eSeq.size()-1) == sSeq.get(0) &&  !S.startsWith(E))
            ) { //(E.length() > S.length()) {
                E = Not(E);
            }
            else {
                E = Double(E);
            }
            operations++;
            System.out.println("E >> "+E);
            System.out.println("E len = "+E.length() + "  --  S = " + S.length());
            eSeq = findCountersSeq(E);
            printArray(eSeq);
            if(operations > 10) break;
        }
        System.out.println("Operatons = "+operations);

    }

    public static void printArray(List<Integer> arr) {
        arr.forEach(x-> System.out.print(x+", "));
        System.out.println();
    }

    public static List<Integer> findCountersSeq(String seq) {
        List<Integer> result = new ArrayList<>();
        char[] chars = seq.toCharArray();
        Character prev = null;
        Integer last = 0;
        for (int i = 0; i < chars.length; i++) {
            Character current = chars[i];
            if(current.equals(prev)) {
                last ++;
                result.set(result.size()-1, last);
            }
            else {
                result.add(1);
                last = 1;
            }
            prev = current;
        }
        return result;
    }

    public static String Double(String v) {
        return v+"0";
    }

    public static String Not(String v) {
        boolean oneFound = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < v.length(); i++) {
            char c = v.charAt(i);
            switch (c) {
                case '1':
                 if(oneFound) {
                     result.append('0');
                 }
                break;
                case '0':
                    oneFound = true;
                    result.append('1');
                    break;
            }
        }
        return result.toString();
    }


    public static String NotExplicit(String v) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < v.length(); i++) {
            char c = v.charAt(i);
            switch (c) {
                case '1':
                    result.append('0');
                    break;
                case '0':
                    result.append('1');
                    break;
            }
        }
        return result.toString();
    }
}
