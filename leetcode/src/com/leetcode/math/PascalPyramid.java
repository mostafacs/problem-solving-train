package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mostafa
 * On 11/9/22
 */

public class PascalPyramid {
    public static ArrayList<Integer> getRow(int rowNum) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0 ; i<=rowNum ; i++){
            list.add(1);
            for(int j=i-1 ; j>0 ; j--){
                list.set(j,list.get(j-1)+list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(7);
        System.out.println();
    }
}