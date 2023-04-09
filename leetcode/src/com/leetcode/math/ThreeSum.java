//package com.leetcode.math;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * @Author Mostafa
// * On 11/3/22
// */
//class Solution {
//    String MAX = String.valueOf(Integer.MAX_VALUE);
//    public int reverse(int x) {
//
//
//        StringBuilder str = new StringBuilder(String.valueOf(x));
//
//        if(str.length() > MAX.length()) return 0;
//        if(str.length() == MAX.length()) {
//            int extra = str.charAt(i) == '-' ? 1 : 0;
//
//            for(int i=0; i < str.length(); i++) {
//                int strNo = Integer.parseInt(String.valueOf(str.charAt(i)));
//                int maxNo = Integer.parseInteger(String.valueOf(MAX.charAt(i)));
//                if(strNo < maxNo) { // 5432..  --
//                    return Integer.parseInt(str.reverse().toString());
//                }
//                else if(maxNo > strNo){
//                    return 0;
//                }
//            }
//            return Integer.MAX_VALUE;
//        }
//
//        return Integer.parseInt(str.reverse(str).toString());
//
//    }
//}