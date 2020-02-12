package com.solution.codejam;

import java.io.*;
import java.util.Scanner;

public class GoYourOwnWay {

    public static String outpath = "go-your-own-way.txt";

    public static void main(String[] args) throws Exception{

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
             int len = in.nextInt();
            String code = in.next();
            String result = solve(code.toCharArray());
            System.out.println("Case #" + (i) + ": " + result);
            out.append("Case #" + (i + 1) + ": " + result + '\n');
        }

        in.close();
        out.close();
    }


    public static String solve(char[] code) {
        for (int i = 0; i < code.length; i++) {
            code[i] = code[i] == 'E' ? 'S' : 'E';
        }
        return new String(code);
    }

}
