package com.solution.codejam.c2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Mostafa
 */
public class ChainReactions {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            int n = in.nextInt();
            // r, c
            Node[] nodes = new Node[n];
            Set<Node> nodesSet = new HashSet();

            for (int i = 0; i < n; i++) {
                int factor = in.nextInt();
                nodes[i] = new Node(i, factor);
                nodesSet.add(nodes[i]);
            }
            // module i points at module Pi.
            for (int i = 0; i < n; i++) {
                Node node = nodes[i];
                int p = in.nextInt();
                if(p > 0) {
                    p--;
                    node.next = nodes[p];
                    nodes[p].prevs.add(node);
                    if(node.prevs.size() > 0) {
                        nodes[p].complexPrevs = true;
                    }
                }
            }

            List<Node> initiators = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(nodes[i].prevs.size() == 0) {
                    initiators.add(nodes[i]);
                }
            }

//            Collections.sort(initiators, Comparator.comparingInt(Node::getFactor));
//
//            int result = 0;
//            for(Node init : initiators) {
//                int max = getMax(init, Integer.MIN_VALUE);
//                result += max;
//            }
            long total = 0;
            for(Node node : initiators) {
                total += node.sumExceptMin();
            }

            System.out.println("Case #"+t+": "+ total );


        }
        in.close();
    }


//    public static long solve(long result, Node current) {
//        Node largestPrev = current.prevs.stream().findFirst().get();
//        Node active;
//        if(current.factor > largestPrev.factor) {
//           active = current;
//        }
//        else {
//            active = largestPrev;
//        }
//
//        result = active.factor;
//        for (Node prevNode : active.prevs) {
//            prevNode.next = null;
//        }
//        if(active.next != null) {
//            result = solve(result, current.next);
//        }
//
//        return result;
//    }

    //     X -->
    //     Y -->
    //


    /*
       (2)
        2 --->   (3)
    (1) 3 --->  1
   (4)  4 --->
                5

    */

    public static class Node {

        public Node(int index, int factor) {
            this.index = index;
            this.factor = factor;
        }

        public int index;
        public int factor;
        public List<Node> prevs = new ArrayList<>();
        public Node next;
        public boolean complexPrevs = false;

        public int getFactor() {
            return factor;
        }

        public int sumExceptMin() {
            int sum = 0;
            if(next == null) {
                System.out.println(index+ ", ");
                sum = factor;
            }

            if(prevs.size() > 0) {
                Collections.sort(prevs, Comparator.comparingInt(Node::getFactor));
                Node max = prevs.get(prevs.size()-1);
                int min = prevs.get(0).factor;
                int start = prevs.size() == 1 ? 0 : 1;

                for (int i = start; i < prevs.size(); i++) {
                    sum += prevs.get(i).factor;
                    System.out.println(prevs.get(i).index+", ");
                }
                if(next != null) {
                    if(factor < max.factor) {
                        // factor = max;
                         System.out.println(" - = "+max);
                        //sum -= factor;
                        sum -= max.factor;
                        factor = max.factor;
                    }
                }


            }


//            for(Node prev : prevs) {
//                if(prev.factor < min) {
//                    min = prev.factor;
//                }
//                sum += prev.factor;
//            }
            return sum;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", factor=" + factor +
                    '}';
        }
    }

}
