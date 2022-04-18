package com.solution.codejam.c2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

            Set<Node> initiators = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if(nodes[i].prevs.size() == 0) {
                    initiators.add(nodes[i]);
                }
            }

            reduce(nodesSet);

            long sum = 0;
            for(Node node : nodesSet) {
//                System.out.println("node -> "+node.factor);
                sum += node.factor;
            }

//
//            for(Node ini : initiators) {
//                if(!nodesSet.contains(ini)) {
//                    sum += ini.factor;
//                }
//            }


            // Set<Integer> used = new HashSet<>();
//            long result = 0;
//            for (int mod : initiators) {
//                if(nodes[mod].isAbyss && nodes[mod].prevs.size() == 0) {
//                    result += nodes[mod].factor;
//                }
//            }
//
//            System.out.println(String.join(", ", initiators.stream().map(i -> i.toString()).collect(Collectors.toList())));

            System.out.println("Case #"+t+": "+ sum );


        }
        in.close();
    }

    public static void reduce(Set<Node> nodes) {
        boolean hasComplexPrevs = false;
        Set<Node> todelete = new HashSet<>();
        for(Node node : nodes) {
            if(node.complexPrevs) {
                hasComplexPrevs = true;
            }
            else {
                if(node.prevs.size() > 0) {
                    Node[] mnMx = minMax(node.prevs);
                    Node min = mnMx[0]; Node max = mnMx[1];

                    if(node.next == null) {

                        if(node.factor > min.factor) {
                            todelete.add(min);
                        }
                        else {
                            todelete.add(node);
                        }

                    }
                    else {
                        if(node.factor > max.factor) {
//                            System.out.println("to delete 1 = "+min);
                            todelete.add(min);
                        }
                        else {
                            if(min.factor < node.factor) {
                                todelete.add(min);
//                                System.out.println("to delete 2 = " + min);
                            }
                            else {
                                todelete.add(node);
//                                System.out.println("to delete 2 = " + node);
                            }

                            max.next = node.next;
                            node.next.prevs.remove(node);
                            node.next.prevs.add(max);
//                            todelete.addAll(node.prevs.stream().filter(n -> n != min).collect(Collectors.toSet()));
                        }
                    }

                    node.prevs.clear();

                }
            }
        }
        nodes.removeAll(todelete);
        todelete.clear();
        if(hasComplexPrevs) {
            reduce(nodes);
        }
    }


    static Node[] minMax(Set<Node> prevs) {
        Node min = null;
        Node max = null;
        for(Node node : prevs) {
            if(min == null) {
                min = node; max=node;
                continue;
            }
            min = node.factor < min.factor ? node : min;
            max = node.factor > max.factor ? node : max;
        }
        return new Node[]{min, max};
    }

    public static long solve(long result, Node current) {
        Node largestPrev = current.prevs.stream().findFirst().get();
        Node active;
        if(current.factor > largestPrev.factor) {
           active = current;
        }
        else {
            active = largestPrev;
        }

        result = active.factor;
        for (Node prevNode : active.prevs) {
            prevNode.next = null;
        }
        if(active.next != null) {
            result = solve(result, current.next);
        }

        return result;
    }

    //     X -->
    //     Y -->
    //
    public static long subtree(Node end) {
        for(Node prev : end.prevs) {
            if(prev.prevs.size() > 0) {

            }
        }
        return -1;
    }


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
        public Set<Node> prevs = new HashSet<>();
        public Node next;
        public boolean complexPrevs = false;

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", factor=" + factor +
                    '}';
        }
    }

}
