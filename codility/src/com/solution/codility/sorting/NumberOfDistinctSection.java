package com.solution.codility.sorting;

import java.util.*;

public class NumberOfDistinctSection {

    public static void main(String[] args) {
//        int[] A = new int[6];
//        A[0] = 1;
//        A[1] = 5;
//        A[2] = 2;
//        A[3] = 1;
//        A[4] = 4;
//        A[5] = 0;
        int[] A = new int[] {1, 2147483647, 0};
        System.out.println(new NumberOfDistinctSection().solution(A));
    }

    public int solution(int[] A) {
        Item[] items = new Item[A.length];
        for (int i = 0; i < A.length; i++) {
            items[i] = new Item(i, A[i]);
        }
        int c = 0;
        for (int i = 0; i < A.length-1; i++) {
            System.out.println(i);

            for (int j = i+1; j < A.length; j++) {
                System.out.println(" >>> Next = "+  items[i].next + "   -   Prev = " + items[j].prev);
                if( items[i].next >= items[j].prev) {
                    System.out.println(i + " intersect with " + j);
                    c++;
                }

                if(c > 10000000) return -1;
            }
        }

        return c;

    }
    
    public int solution2(int[] A) {

        int c = 0;
        boolean[] processed = new boolean[A.length];
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            items.add(new Item(i, A[i]));
        }

//        Collections.sort(items, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return (int) (o2.raduis - o1.raduis);
//            }
//        });


        for (int i = 0; i < A.length; i++) {
            Item item = items.get(i);
//            if(!processed[item.orig]) {
//
//
//                processed[item.orig] =true;
//            }
        }
        return 0;
    }
}

class Item {

    public int prev;
    public int next;

    private Item() {

    }

    public Item(int orig, int radius) {

        this.next = orig+radius;
        this.prev = orig - radius;
        this.next = this.next * -1;
        System.out.println("orig="+orig);
        System.out.println("radius="+radius);
        System.out.println("SUM = "+ this.next);
        System.out.println(this.next);

    }
}
