package com.leetcode.surround;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mostafa
 */
class SurroundRegion {


    public static void main(String[] args) {
        char[][] board = {{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},{'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
                
                // { {'X','X','X','X','X'},{'X','O','O','O','X'}, {'X','X','O','O','X'}, {'X','X','X','O','X'}, {'X','O','X','X','X'}};
        solve(board);

        System.out.println(board);
    }

    public static void solve(char[][] board) {

        Set<Integer> visitedX = new HashSet();
        Set<Integer> visitedY = new HashSet();


        for(int i= 1;i<board.length-1; i++) {

            for(int j=1;j < board[i].length-1; j++) {
                char c = board[i][j];
                if(c == 'O') {
                    isValid(board, i, j, visitedX, visitedY);
                }
            }
        }

    }

    public static boolean isValid(char[][] board, int i, int j,
                           Set<Integer> visitedX, Set<Integer> visitedY) {

        // board[i][j] = 'P';
        visitedX.add(i);
        visitedY.add(j);

        char[] neighbors = new char[4];
        neighbors[0] = board[i-1][j];
        neighbors[1] = board[i+1][j];
        neighbors[2] = board[i][j-1];
        neighbors[3] = board[i][j+1];

        for(int n=0; n < neighbors.length; n++) {

            int x, y;
            if(n == 0) { x = i-1; y=j; }
            else if(n == 1) { x = i+1; y=j; }
            else if(n == 2) { x = i; y=j-1; }
            else { x = i; y=j+1; }

            boolean nvalid = neighbors[n] == 'X';
            if(!nvalid) {
                if(!onBorder(x, y, board.length, board[x].length) )
                {
                    if ( !(visitedX.contains(x) && visitedY.contains(y)) ) {
                        nvalid = isValid(board, x, y, visitedX, visitedY);
                    }
                    else {
                        nvalid = neighbors[n] == 'X';
                    }
                }
            }
            if(!nvalid) {
                board[i][j] = 'O';
                return false;
            }
        }
        board[i][j] = 'X';
        return true;

    }

    public static boolean onBorder(int i, int j, int m, int n) {
        if(i == 0 || j == 0) return true;
        if( i ==  m-1 || j == n-1) return true;
        return false;
    }
}