package com.solution.codejam.c2020.round1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mostafa
 */
public class JoinTheRanksCalc {

    static boolean debug = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int r = in.nextInt();
            int s = in.nextInt();


            System.out.println("Case #"+t+": "+ Math.ceil(((double)(r*s-r))/2.0) );
            //solve(r, s);
          JoinTheRanks.Card[] cards = JoinTheRanks.generateTheRank(r, s);
            solveWithDebug(cards, r, s);
            System.out.println();
            System.out.println("--------------------");
            System.out.println();
            //solve(r, s);
        }
    }


    public static void solve2(JoinTheRanks.Card[] cards, int rs, int ss) {

        JoinTheRanks.printCards(cards);
        while (true) {

            cards = substitute(cards, rs, ss);
            System.out.println(ss+" "+rs);

            JoinTheRanks.printCards(cards);

            ss--;



        }
    }


    public static void solve(int rs, int ss) {
        for (int s = 1; s < ss; s++) {

            for (int r = 1; r < rs; r+=2) {

                int size1 = (s*rs)+(r-1);//*(sr+1);//(r+1);
                if(size1 !=2) {
                    System.out.println(size1 + " 2");

                }
                int size2 = (s+1) * (r-1) + s;
                System.out.println("2 "+ size2);
            }
        }
    }
    
    private static void solveWithDebug(JoinTheRanks.Card[] cards, int rs, int ss) {

        JoinTheRanks.printCards(cards);

        // S here represent sorted collection
        for (int s = 1; s < ss; s++) {

            for (int r = 1; r < rs; r+=2) {

                System.out.println(" RS = "+rs +" - S="+s + " -  R="+r);
                int size1 = (s*rs)+(r-1);//*(sr+1);//(r+1);
                System.out.println("Size 1=" + size1);
                int size21 = s < 2 ? s : 2;
                cards = substitute(cards, size1, size21);
                JoinTheRanks.printCards(cards);
                int size22 = (s+1) * (r-1) + s;
                System.out.println("Size(2) => "+size22 );
                cards = substitute(cards, size21, size22);
                JoinTheRanks.printCards(cards);
            }
        }
    }

    private static JoinTheRanks.Card[] substitute(JoinTheRanks.Card[] cards, int size1, int size2) {
        JoinTheRanks.Card[] newCards = new JoinTheRanks.Card[cards.length];
//        if(size2 == 10){
//            System.out.println("ss");
//            size2 -=2;
//        }
        for (int i = 0; i < size2; i++) {
            newCards[i] = cards[size1+i];
        }
        for (int i = 0; i < size1; i++) {
            newCards[size2+i] = cards[i];
        }
        if(size1 + size2 < cards.length) {
            for (int i = size1+size2; i < cards.length; i++) {
                newCards[i] = cards[i];
            }
        }
        return newCards;
    }

}
