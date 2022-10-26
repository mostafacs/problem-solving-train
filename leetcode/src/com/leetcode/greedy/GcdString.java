package com.leetcode.greedy;

/**
 * @Author Mostafa
 * On 10/20/22
 */
public class GcdString {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }

    public static String gcdOfStrings(String str1, String str2) {

        // getCommonFirst prefix

        int min = str1.length() > str2.length() ? str2.length() : str1.length();

        String commonPrefix = "";
        for(int i=0; i < min; i++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                commonPrefix += str1.charAt(i);
            }
            else break;
        }

        if(commonPrefix.length() == 0) return commonPrefix;

        // System.out.println(commonPrefix);
        while(str1.length() % commonPrefix.length() != 0 || str2.length() % commonPrefix.length() != 0) {
            commonPrefix = commonPrefix.substring(0, commonPrefix.length() -1 );
        }

        if(commonPrefix.length() == 0) return "";

        String part = "";
        int cpindex = 0;
        for(int i=commonPrefix.length(); i < str1.length(); i++) {
            if(i % commonPrefix.length() == 0) cpindex = 0;
            if(str1.charAt(i) != commonPrefix.charAt(cpindex)) {
                return "";
            }
            cpindex++;
        }


        return commonPrefix;

    }
}
