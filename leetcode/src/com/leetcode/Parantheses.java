package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mostafa
 * On 11/15/22
 */
public class Parantheses {

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println();
    }


        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList(n);
            if(n == 1) {
                result.add("()");
                return result;
            }
            String firstItem = "";
            for(int i=0; i < n; i++) {
                firstItem += "()";
            }
            result.add(firstItem);


            boolean completed = false;
            int from = 1;
            int to = 3;
            int shiftIndex = 1;
            while(shiftIndex < n) {

                char[] current = new char[n*2];
                for(int i=0; i < firstItem.length(); i++) {
                    if(i < from) {
                        current[i] = firstItem.charAt(i);
                    }
                    else if ( i == to) {
                        current[i] = ')';
                    }
                    else if( i >= from && i < to){
                        current[i] = firstItem.charAt(i-1);
                    }
                    else if( i >= to) {
                        current[i] = firstItem.charAt(i);
                    }
                }
                result.add(new String(current));
                to += 2;
                if(to > firstItem.length()-1) {
                    shiftIndex++;
                    from = (shiftIndex *2) - 1;
                    to = from + 2;
                }
            }
            return result;
        }
}
