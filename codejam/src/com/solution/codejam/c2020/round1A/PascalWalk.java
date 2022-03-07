package com.solution.codejam.c2020.round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Mostafa
 * 1
 * 25
 */
public class PascalWalk {

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            long N = in.nextLong();
            System.out.println("Case #"+ t +":");
            System.out.println("1 1");
            if(N > 1) {
                System.out.println("2 2");
            }
            if( N > 2) {
                solve(N, 2, 2, 2, new long[]{1, 1}, Direction.TOP);
            }
            // System.out.println("-------------");
        }
    }

    /*
    K =


    13
               1x
            1    1x
          1    2x   1
        1    3   3x   1x
      1   4    6   4x   1x
     1  5   10  10    x5   x1
    1  6  15   20  15   6   1
  1  7   21 35    35  21   7   1

    * */

    public enum Direction{ TOP, LEFT, RIGHT }

    // 13496 failed 13496
    // 13509
    public static void solve(long target, long current, int r, int k, long[] prevs, Direction direction) throws Exception{
        // System.out.println("Current = "+current);

        if(current == target) {
           // System.out.println(">> Complete = "+current);
            return;
        }

        long right = k < prevs.length ?  prevs[k] : 0;
        long left =  k-2 > -1 ? prevs[k-2] : 0;

        if(direction != Direction.LEFT && k < prevs.length && current + right  == target) {
            System.out.println((r)+" "+(k+1));
            // System.out.println("Complete = "+target);
            return;
        }
        if(direction != Direction.RIGHT && k-2 > -1 && current + left  == target) {
             System.out.println((r)+" "+(k-1));
             // System.out.println("Complete = "+ target);
            return;
        }

        long[] nextRow = findValues(r+1, prevs);
        long bottomLeft = nextRow[k-1]; // k // k-1
        long bottomRight = nextRow[k]; // k+1 // k

       // System.out.println((target - (current + bottomLeft)) +" >= " +(bottomRight + bottomLeft));
       // System.out.println( (target - (current + bottomRight)) +" >= " +(bottomRight + bottomLeft));

        if(current + bottomLeft == target) {
            System.out.println((r+1)+" "+k);
             // System.out.println("Complete = "+ target);
        }
        else if(current + bottomRight == target) {
            System.out.println((r+1)+" "+ (k+1));
             // System.out.println("Complete = "+ target);
        }


        // 13430 13496


        else if(bottomLeft > bottomRight && current+bottomLeft < target  && (bottomLeft == 1 ||  (target - (current + bottomLeft)) >= (bottomLeft + bottomRight * ((r+1)%k)) ) ) {
            System.out.println((r+1)+" "+k);
            solve(target, current+bottomLeft, r+1, k, nextRow, Direction.TOP);
        }
        else if(current+bottomRight < target  && ( bottomRight == 1 || (target - (current + bottomRight)) >= (bottomRight + bottomLeft * ( (r+1)%(k+1) ) ) ) ) {
            System.out.println((r+1)+" "+ (k+1));
            solve(target, current+bottomRight, r+1, k+1, nextRow, Direction.TOP);
        }

        else if(direction != Direction.LEFT && k < prevs.length && current + right < target) {
            System.out.println((r)+" "+(k+1));
            solve(target, current + right, r, k+1, prevs, Direction.RIGHT);
        }
        else if(direction != Direction.RIGHT && k-2 > -1 && current + left < target) {
            System.out.println((r)+" "+(k-1));
            solve(target, current + left, r, k-1, prevs, Direction.LEFT);
        }
        else {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n >>>>>>>>>>>>>>>>>>>>>>>");
            throw new Exception("Can't get it completed");
        }

       // System.out.println("Current =>>>> "+current);

    }
//
//    static int[] getNeigbours(int r, int k) {
//
//    }


    static long[] findValues(int r, long[] prevs) {
        long[] result = new long[r];
        for (int i = 1; i < r-1; i++) {
             result[i] = prevs[i-1] + prevs[i];
        }
        result[0] = 1;
        result[r-1] = 1;
        return result;
    }


}
