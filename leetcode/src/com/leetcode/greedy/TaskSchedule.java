package com.leetcode.greedy;

import java.util.*;

/**
 * @Author Mostafa
 * On 10/10/22
 */
class TaskSchedule {

    public static void main(String[] args) {
        // System.out.println(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        System.out.println("sss".substring(0, "sss".length()-1));
    }

    class CharCount {
        Character c;
        int count;
    }

    public static int leastInterval(char[] tasks, int n) {
        // LinkedList<Character> keys = new LinkedList();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        {
            Map<Character, Integer> counts = new TreeMap<>();
            for(char c : tasks) {
                if (counts.containsKey(c)) {
                    counts.put(c, counts.get(c) + 1);
                } else {
                    counts.put(c, 1);
                }
            }
            for(int value : counts.values()) {
                queue.add(value);
            }
        }


        int result = 0;


        while(queue.size() > 0) {

            int cooler = n+1;

            List<Integer> toFill = new ArrayList<>(queue.size());
            int availableTasksCount = queue.size();
            for (int i = 0; i < availableTasksCount && cooler > 0; i++) {
                int current = queue.poll();
                result++;
                cooler --;
                current --;
                if(current > 0) {
                    toFill.add(current);
                }
            }

            queue.addAll(toFill);

            if(queue.isEmpty()) return result;

            if(cooler > 0) {
                result += cooler;
            }

        }

        return result;
    }
}