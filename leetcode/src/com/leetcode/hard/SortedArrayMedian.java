package com.leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;

public class SortedArrayMedian {

        public double findMedianSortedArrays1(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] flatList = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            flatList[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            flatList[nums1.length + i] = nums2[i];
        }

        Arrays.sort(flatList);

        if(flatList.length == 1) {
            return  flatList[0];
        }

        if (flatList.length % 2 == 0) {
            int index = flatList.length / 2;
            return ((double)(flatList[index] + flatList[index -1])) / 2 ;
        }

        return flatList[flatList.length / 2 ];
    }

    public static void main(String[] args) {
//        double c = new SortedArrayMedian().findMedianSortedArrays(new int[]{1, 2, 5, 6}, new int[]{9, 4});
//        System.out.println(c);
////        c = new SortedArrayMedian().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
////        System.out.println(c);
//        System.out.println(new SortedArrayMedian().lengthOfLongestSubstring("pwwkew"));
//        System.out.println(new SortedArrayMedian().longestPalindrome("babad"));
        System.out.println(new SortedArrayMedian().isMatch("aab", "c*a*b")); // true
        System.out.println(new SortedArrayMedian().isMatch("a", "a*")); // true
        System.out.println(new SortedArrayMedian().isMatch("ab", ".*c")); // false
        System.out.println(new SortedArrayMedian().isMatch("bbb", "bb")); // false
        System.out.println(new SortedArrayMedian().isMatch("aaaaaaaaa", "a*a")); // true
        System.out.println(new SortedArrayMedian().isMatch("aaa", "a*a")); // true

    }


    public int lengthOfLongestSubstring(String s) {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                HashSet bag = new HashSet();
                int size = 0;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if(bag.contains(c)) {
                        max = max < size ? size : max;
                        break;
                    }
                    size ++;
                    bag.add(c);
                }
                max = max < size ? size : max;
            }
            return max;
    }



    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        if (isPalindrome(s)) return s;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                String cs = sb.toString();
                if(isPalindrome(cs)) {
                    if(sb.length() > result.length()) {
                        result = cs;
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String str){
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }

        return true;
    }

    public boolean isMatch(String s, String p) {
        int si = 0, pi = 0;
        while (si < s.length() && pi < p.length()) {
           //  System.out.println("Pattern = "+ p.charAt(pi) + " , pi = " + pi + " - Str = si - " + si + " - " + s.charAt(si));
            switch (p.charAt(pi)) {
                case '*':
                    if(pi> 0 && p.charAt(pi-1) == '.') {
                        si++;
                    } else if (p.charAt(pi-1) == s.charAt(si)) {
                        if(s.length() - si <= p.length() - pi)
                            pi++;
                        si++;

                    } else {
                       // si++;
                        pi++;
                    }
                    break;
                case '.':
                    si++;
                    pi++;
                    break;
                default:
                    if(p.charAt(pi) == s.charAt(si)) {
                        si++;
                        pi++;
                    } else {
                        if(pi ==0 && p.charAt(pi+1) == '*') {
                            pi++;
                            continue;
                        }
                        return false;
                    }


            }
        }

        while (pi < p.length()) {
            if(p.charAt(pi) == '*') pi++;
            else break;
        }
       // System.out.println(si + " "+ pi);
        return si == s.length()  && pi == p.length();
    }
}
