package com.leetcode.math;

/**
 * @author Mostafa
 */
public class MaximalRectangle {


    public static void main(String[] args) {
        char[][] data1 = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] data2 = {{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}};
        // int r1 = maximalRectangle(data1);
        int r1 = maximalRectangle(data2);
        System.out.println(r1);
    }

    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        int[][][] counts = new int[matrix.length][matrix[0].length][2];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int current =  matrix[i][j] == '1' ? 1 : 0;

                if(current == 0 ) {
                    counts[i][j][0] = 0;
                    counts[i][j][1] = 0;
                }
                else {
                    if (i == 0 && j == 0) {
                        counts[i][j][0] = 1;
                        counts[i][j][1] = 1;

                    }
                    // first row
                    else if (i == 0) {
                        // width
                        counts[i][j][0] = counts[i][j-1][0] + 1;
                        // height
                        counts[i][j][1] = 1;
                    }
                    // first columnn
                    else if (j == 0) {
                        // width
                        counts[i][j][0] = 1;
                        // height
                        counts[i][j][1] = counts[i-1][j][1] + 1;
                    }
                    else {
                        // width
                        counts[i][j][0] = counts[i][j-1][0] + 1;
                        // height
                        counts[i][j][1] = counts[i-1][j][1] + 1;
                    }

                    int minWidth = counts[i][j][0];
                    int newArea = counts[i][j][0];
                    maxArea = newArea > maxArea ? newArea : maxArea;
                    for (int k = 1; k < counts[i][j][1]; k++) {
                        minWidth = Math.min(minWidth, counts[i-k][j][0]);
                        newArea = minWidth  * (k+1);
                        maxArea = newArea > maxArea ? newArea : maxArea;

                    }
                }
            }
        }
        return maxArea;
    }



}
