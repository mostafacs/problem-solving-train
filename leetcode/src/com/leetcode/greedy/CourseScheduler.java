package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mostafa
 */
public class CourseScheduler {


    public static void main(String[] args) {
        int[][] courses = new int[][] {{100,200},{200,1300},{1000,1250},{2000,3200}};

        Arrays.sort(courses, Comparator.comparingInt(o -> o[1] - o[0]));

        int counter = 0;
        int currentTime = 0;
        for (int i = 0; i < courses.length; i++) {

            int duration = courses[i][0];
            int lastDay = courses[i][1];
            currentTime += duration;

            if(currentTime > lastDay) continue;
            counter ++;
        }

        System.out.println(counter);
    }
}
