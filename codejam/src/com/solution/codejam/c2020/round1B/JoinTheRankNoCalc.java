package com.solution.codejam.c2020.round1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Mostafa
 */

/**
 * The only right solution
 */
public class JoinTheRankNoCalc {

    // 123456 123456
    // [12][3456 1]23456
    // [3456][11223]456
    // [1122334][56]456
    // [56] [112233445]6
    // 112233445566

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int r = in.nextInt();
            int s = in.nextInt();

            Card[] cards = generateTheRank(r, s);
            //printCards(cards);
            System.out.println("Case #" + t +": "+  ((r* (s-1))+1)/2 ) ;

            solve(cards, r, s);


        }
    }


    public static void solve(Card[] cards, int rc, int sc) {

        int size = rc * sc;
        int r = 2;
        int s=2;
        //System.out.println("SC = "+ sc + " - rc = "+rc);
        int count = 0;
        while( (s == sc && r > rc) == false ) {
            // System.out.println("R = "+r +" S = "+s);

            count++;
            int first = 0;
            if(r > rc)  {
                s++;
                if(  (s-1)*rc > (size-rc) )  {
                    if(sc % 2 == 0)
                     r--;
                    else
                      r = 1;
                }
                else {
                    if(cards[0].r == 1) r = 2;
                    else r = 1;
                }
                //sortedCount-=2;
            }



            if(r > rc) {
                //first = sortedCount + 2;
                r = 2;
            }
            int second = 0;
            // System.out.println("R2 = "+r);
            first = lastIndexOfSize(cards, r, 0);
            second = firstIndexOfSize(cards, r, first);


            System.out.println(first +" "+second);

            cards = substitute(cards, first, second);
            // printCards(cards);

            if(r == rc-1 && s == sc) {
                r += 1;
            } else {
                r += 2;
            }

            //System.out.println("Cuurrent r="+r);

        }


        // System.out.println("Count = "+count);


    }


    public static int lastIndexOfSize(Card[] cards, int value, int from) {
        boolean found = false;
        int size = 0;
        while ( !(found && cards[from].r != value) ) {
            if(cards[from].r == value) {
                found = true;
            }
            from ++;
            size++;
        }
        return size;
    }

    public static int firstIndexOfSize(Card[] cards, int value, int from) {
        int size=0;
        while (cards[from].r != value) {
            from ++;
            size ++;
        }
        return size;
    }


    private static Card[] substitute(Card[] cards, int size1, int size2) {
        Card[] newCards = new Card[cards.length];

        for (int i = 0; i < size2; i++) {
            newCards[i] = cards[size1 + i];
        }
        for (int i = 0; i < size1; i++) {
            newCards[size2 + i] = cards[i];
        }
        if (size1 + size2 < cards.length) {
            for (int i = size1 + size2; i < cards.length; i++) {
                newCards[i] = cards[i];
            }
        }
        return newCards;
    }

    public static Card[] generateTheRank(int r, int s) {
        Card[] result = new Card[r * s];
        int c = 0;
        for (int is = 0; is < s; is++) {
            for (int ir = 0; ir < r; ir++) {
                result[c] = new Card((ir + 1), (is + 1));
                c++;
            }
        }
        return result;
    }

    public static void printCards(Card[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println();
    }

    public static class Card {
        int r;
        int s;

        public Card(int r, int s) {
            this.r = r;
            this.s = s;
        }


        @Override
        public String toString() {
            // return "("+ r +", " + s + ")";
            return "(" + r + ")";
        }
    }

}
