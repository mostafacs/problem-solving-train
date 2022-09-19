package com.solution.codejam.c2022.round1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Mostafa
 */
public class MegaTower {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int n = in.nextInt();
            LinkedList<String> queue = new LinkedList<>();
            String firstItem = "";
            for (int i = 1; i <= n ; i++) {
                String newItem = in.next();
                if(i == 1) {
                    firstItem = newItem;
                    // queue.add(newItem);
                }
                else {
                    insertIntoQueue(queue, newItem);
                    //System.out.println(String.join("", queue));
                    System.out.println(String.join("", queue));

                }
            }


            /*
            1
5
ROAD YCVR BET DY R
            * */

//            System.out.println(" --------- ");
//            queue.remove(firstItem);
//            System.out.println(String.join("", queue));
           insertIntoQueue(queue, firstItem);

            String result = String.join("", queue);
            System.out.println("Case #"+ t +": "+result);

            if(isValid(result)) {
                System.out.println("Case #"+ t +": "+result);
            }
            else {
                System.out.println("Case #"+ t +": IMPOSSIBLE");
            }

        }
        in.close();
    }

    public static void insertIntoQueue(LinkedList<String> queue, String newItem) {
        boolean inserted = false;
        int size = queue.size();
        for(int j = 0; j < size; j++) {
            String current = queue.get(j);
//            if(current.charAt(0) == newItem.charAt(newItem.length()-1)) {
//                queue.add(j, newItem);
//                inserted = true;
//                break;
//            }
//            else
                if(current.charAt(current.length()-1) == newItem.charAt(0)) {
                queue.add(j+1, newItem);
                inserted = true;
                break;
            }
//                        else if(current.charAt(0) == newItem.charAt(newItem.length() -1)) {
//                            queue.add(j-1, newItem);
//                            inserted = true;
//                            break;
//                        }

        }

        if(!inserted) {
            for(int j = 0; j < size; j++) {
                String current = queue.get(j);
            if(current.charAt(0) == newItem.charAt(newItem.length()-1)) {
                queue.add(j, newItem);
                inserted = true;
                break;
            }
            }
        }

        if(!inserted) {
            queue.addLast(newItem);
        }
    }

    public static boolean isValid(String value) {
        char prev = value.charAt(0);
        Set<Character> found = new HashSet<>();
        found.add(prev);
        for (int i = 1; i < value.length(); i++) {
            char current = value.charAt(i);
            if( current != prev) {
                if(found.contains(current)) {
                    return false;
                }
                found.add(current);
                prev = current;
            }
        }
        return true;
    }
}
