package com.solution.codejam.c2020.round1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

    N
W       E
    S
 */
public class Expogo {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        // x = y +1
        // x = y-1
        for (int t = 1; t <= T; t++) {

            int x = in.nextInt();
            int y = in.nextInt();

            int absX = Math.abs(x),
                    absY = Math.abs(y);

//            int diff = Math.abs(absX-absY);
            int xMod = x%2, yMod = y%2;
            if (xMod == yMod) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } /*else if (xMod != 0 && yMod != 0) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } */else {
                //int diff = x-y;
                int cx = 0, cy = 0;
                StringBuilder solution = new StringBuilder();
                char oddFlag = 'y';
                int even=x, odd=y;
                if(xMod != 0) {
                    oddFlag = 'x';
                    even=y; odd=x;
                }

                if(even == 0) {
                   // System.out.println((odd - 1) / 2);
                   // System.out.println(((odd - 1) / 2) % 2);
                    if(((odd - 1) / 2) % 2 == 0) {
                       // System.out.println("xxx 1111");
                        if (oddFlag == 'x') {
                            solution.append("W");
                            cx--;
                        } else {
                            solution.append("S");
                            cy--;
                        }
                    } else {
                        //System.out.println("xxx 1111");

                        if (oddFlag == 'x') {
                            solution.append("E");
                            cx++;
                        } else {
                            solution.append("N");
                            cy++;
                        }
                    }
                    checkForInverse(x, y, solution);
                }else {
                    int numerator = Math.abs(odd)+1;
                    int denumerator = Math.abs(even);
                    if(numerator < denumerator) {
                        int swap = numerator;
                        numerator = denumerator;
                        denumerator = swap;
                    }
                    if ( (numerator) % denumerator == 0) {
                        if (oddFlag == 'x') {
                            solution.append("E");
                            cx++;
                        } else {
                            solution.append("N");
                            cy++;
                        }
                    } else if ((numerator - 2) % denumerator == 0) {
                        if (oddFlag == 'x') {
                            solution.append("W");
                            cx--;
                        } else {
                            solution.append("S");
                            cy--;
                        }

                    } else {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        continue;
                    }
                }

                int jump = 2;
                do {
                    //System.out.println("CX = "+cx + " - CY = "+cy + " - Solution = "+solution.toString());

                    if(oddFlag == 'x') {
                        if ((cx + jump) == absX) {
                            cx += jump;
                            solution.append('E');
                        } else if ((cy + jump) <= absY) {
                            cy += jump;
                            solution.append('N');
                        } else
                            break;
                    } else {
                        if ((cy + jump) == absY) {
                            cy += jump;
                            solution.append('N');
                        } else if ((cx + jump) <= absX) {
                            cx += jump;
                            solution.append('E');
                        } else
                            break;
                    }

                    //else if(cy + jump == absY) { cy = cy+jump; solution.append('N'); }
//                    else {
//                        if(oddFlag == 'x' && cx < absX) { cx = cx+jump; solution.append('E'); }
//                        else { cy = cy+jump; solution.append('N'); }
//                    }


                    jump *= 2;
//                    System.out.println("CX = "+cx + " - CY = "+cy + " - Solution = "+solution.toString());
//                    System.out.println("absX = "+absX + " - absY = "+absY);

                } while (!(cx == absX && cy == absY));

                if(cx == absX && cy == absY) {
                    //System.out.println("Case #" + t + ": "+solution.toString());
                    checkForInverse(x, y, solution);


                    System.out.println("Case #" + t + ": " + solution.toString());
                } else
                    System.out.println("Case #" + t + ": IMPOSSIBLE");

            }

        }

        in.close();
    }

    static void checkForInverse(int x, int y, StringBuilder solution) {
        if (x < 0 || y < 0) {
            for (int i = 0; i < solution.length(); i++) {
                if(x < 0) {
                    if(solution.charAt(i) == 'E') solution.setCharAt(i, 'W');
                    else if(solution.charAt(i) == 'W') solution.setCharAt(i, 'E');
                }

                if(y < 0) {
                    if(solution.charAt(i) == 'S') solution.setCharAt(i, 'N');
                    else if(solution.charAt(i) == 'N') solution.setCharAt(i, 'S');
                }

            }
        }
    }

}
