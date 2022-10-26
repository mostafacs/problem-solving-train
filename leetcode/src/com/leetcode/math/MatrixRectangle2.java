//package com.leetcode.math;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author Mostafa
// * On 10/24/22
// */
//public class MatrixRectangle2 {
//
//    public static int maximalRectangle(char[][] matrix) {
//
//        int[][] widths = new int[matrix.length][matrix[0].length];
//        for(int r=0; r < matrix.length; r++) {
//            int count = 0;
//            for(int c=0; c < matrix[r].length; c++) {
//                if(matrix[r][c] == '0') {
//                    count = 0;
//                }
//                else {
//                    widths[r][c] = ++count;
//                }
//            }
//        }
//
//        int[][] sum = new int[matrix.length][matrix[0].length];
//        for(int r=0; r < matrix.length; r++) {
//            int count = 0;
//            for(int c=0; c < matrix[r].length; c++) {
//                if(matrix[r][c] == '0') {
//                    count = 0;
//                }
//                else {
//                    sum[r][c] = ++count;
//                }
//            }
//        }
//
//        int maxArea = 0;
//        for(int c=0; c < matrix[0].length; c++) {
////            int width = Integer.MAX_VALUE;
//            //int height = 0;
//
//            // remove this and replace it with a list traverse with the inverse
//            List<MaximalRectangle.Area> possibleWidthHeights = new ArrayList<>(matrix.length);
//            for(int r=0; r < matrix.length; r++) {
//                int value = sum[r][c];
//                if(value == 0) {
//                    // height = 0; // width=Integer.MAX_VALUE;
//                    maxArea = findMax(possibleWidthHeights, maxArea);
//                    possibleWidthHeights.clear();
//                }
//                else {
////                    height++;
//                    int myHeight = 1;
//                    // boolean shouldBreak = false;
//                    for (int i = possibleWidthHeights.size()-1; i > -1 ; i--) {
//                        MaximalRectangle.Area area = possibleWidthHeights.get(i);
//                        if(area.width <= value) {
//                            area.height ++;
//                        }
//
//                        if(area.width >= value) {
////                            if(shouldBreak) {
////                                break;
////                            }
//                            myHeight ++;
//                        }
//
//                        if(area.width < value) {
//                            //shouldBreak = true;
//                            break;
//                        }
//
//                    }
//                    possibleWidthHeights.add(new MaximalRectangle.Area(value, myHeight));
//
////                    if(!possibleWidthHeights.containsKey(value)) {
////                        possibleWidthHeights.put(value, myHeight);
////                    }
//                }
//            }
//
//            if(!possibleWidthHeights.isEmpty()) {
//                maxArea = findMax(possibleWidthHeights, maxArea);
//            }
//        }
//        return maxArea;
//    }
//
//}
