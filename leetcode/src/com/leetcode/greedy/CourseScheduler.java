package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mostafa
 */
public class CourseScheduler {


    public static void main(String[] args) {
        // [[5,15],[3,19],[6,7],[2,10],[5,16],[8,14],[10,11],[2,19]]
        int[][] courses = new int[][] {{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}}; //{{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}}; // {{10,20},{4,13},{4,4},{3,11},{3,5},{3,5}}; // {{100,200},{200,1300},{1000,1250},{2000,3200}};

        // [[5,5],[4,6],[2,6]]

        Arrays.sort(courses, Comparator.comparingDouble(o ->

        { double v = ((double) o[1]); //(o[0]*o[1])/o[1];
//            System.out.println(o[0] +" - " + o[1] + " = "+v);
            return v;
        }) );

        PriorityQueue priorityQueue = new PriorityQueue(Comparator.reverseOrder());

        for (int i = 0; i < courses.length; i++) {
            priorityQueue.add(courses[i][0]);
        }

        int solution = solve(courses);

        System.out.println(solution);
        //return counter;

    }


    static int solve(int[][] courses) {
        int currentTime = 0;

        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Integer> durationQueue = new PriorityQueue(Comparator.reverseOrder());

        for (int i = 0; i < courses.length; i++) {

            int duration = courses[i][0];
            int lastDay = courses[i][1];

            durationQueue.add(duration);

            currentTime += duration;
            if(currentTime > lastDay) {
                System.out.println(durationQueue.peek());
                currentTime -= durationQueue.poll();
            }
        }
        return durationQueue.size();
    }
}
