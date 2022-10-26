package com.leetcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mostafa
 * On 10/24/22
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] a = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] b = new char[][]{{'0','0','1'}, {'1','1','1'}};
        char[][] c = new char[][] {{'0','0','1','0'}, {'0','0','1','0'}, {'0','0','1','0'}, {'0','0','1','1'}, {'0','1','1','1'},{'0','1','1','1'}, {'1','1','1','1'}};
        char[][] d = new char[][] {{'1','0','1','1','0','1'}, {'1','1','1','1','1','1'}, {'0','1','1','0','1','1'}, {'1','1','1','0','1','0'}, {'0','1','1','1','1','1'}, {'1','1','0','1','1','1'}};

        char[][] e = new char[][] {
                {'1','0','1','0','0','1','1','1','0'},
                {'1','1','1','0','0','0','0','0','1'},
                {'0','0','1','1','0','0','0','1','1'},
                {'0','1','1','0','0','1','0','0','1'},
        {'1','1','0','1','1','0','0','1','0'},
                {'0','1','1','1','1','1','1','0','1'},
            {'1','0','1','1','1','0','0','1','0'},
                {'1','1','1','0','1','0','0','0','1'},
                {'0','1','1','1','1','0','0','1', '0'},
            {'1','0','0','1','1','1','0','0','0'}
        };
//         System.out.println( maximalRectangle(a) );
//         System.out.println( maximalRectangle(b) );
//         System.out.println( maximalRectangle(c) ); // 9
//
//

        System.out.println( maximalRectangle(e) ); // 6


        char[][] f =new char[][] {{'0','0','0','0','0','0','1'},{'0','0','0','0','1','1','1'},{'1','1','1','1','1','1','1'},{'0','0','0','1','1','1','1'}};  // 9
        System.out.println( maximalRectangle(f) );

    }


    public static int maximalRectangle(char[][] matrix) {

        int[][] sum = new int[matrix.length][matrix[0].length];
        for(int r=0; r < matrix.length; r++) {
            int count = 0;
            for(int c=0; c < matrix[r].length; c++) {
                if(matrix[r][c] == '0') {
                    count = 0;
                }
                else {
                    sum[r][c] = ++count;
                }
            }
        }

        int maxArea = 0;
        for(int c=0; c < matrix[0].length; c++) {
//            int width = Integer.MAX_VALUE;
            //int height = 0;

            // remove this and replace it with a list traverse with the inverse
            List<Area> possibleWidthHeights = new ArrayList<>(matrix.length);
            for(int r=0; r < matrix.length; r++) {
                int value = sum[r][c];
                if(value == 0) {
                    // height = 0; // width=Integer.MAX_VALUE;
                    maxArea = findMax(possibleWidthHeights, maxArea);
                    possibleWidthHeights.clear();
                }
                else {
//                    height++;
                    int myHeight = 1;
                    // boolean shouldBreak = false;
                    for (int i = possibleWidthHeights.size()-1; i > -1 ; i--) {
                        Area area = possibleWidthHeights.get(i);
                        if(area.width <= value) {
                            area.height ++;
                        }

                        if(area.width >= value) {
//                            if(shouldBreak) {
//                                break;
//                            }
                            myHeight ++;
                        }

                        if(area.width < value) {
                            //shouldBreak = true;
                            break;
                        }

                    }
                    possibleWidthHeights.add(new Area(value, myHeight));

//                    if(!possibleWidthHeights.containsKey(value)) {
//                        possibleWidthHeights.put(value, myHeight);
//                    }
                }
            }

            if(!possibleWidthHeights.isEmpty()) {
                maxArea = findMax(possibleWidthHeights, maxArea);
            }
        }
        return maxArea;
    }


    static int findMax(List<Area> areas, int maxArea) {
        for(Area obj : areas) {
            int area = obj.height * obj.width;
            if(area >= maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    static class Area {

        public Area() {
        }

        public Area(int width, int height) {
            this.width = width;
            this.height = height;
        }

        int width;
        int height;
    }
}
