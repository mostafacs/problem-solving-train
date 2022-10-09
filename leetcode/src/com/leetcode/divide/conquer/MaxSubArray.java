package com.leetcode.divide.conquer;

/**
 * @Author Mostafa
 * On 10/7/22
 */
public class MaxSubArray {


    public static void main(String[] args) {

        System.out.println("RES = ");
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-1,-2,-3,0}));
        System.out.println("RES = ");
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1}));
        System.out.println("RES = ");
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(new MaxSubArray().maxSubArray(new int[]{1}));
//        System.out.println(new MaxSubArray().maxSubArray(new int[]{1, -1}));


    }


    public int maxSubArray(int[] nums) {
        int n = nums.length;

        return iterativeFind(nums, 0, n - 1, Integer.MIN_VALUE);
    }


    int iterativeFind(int[] nums, int from, int to, int max) {
//
        if(to - from == 0) {
            return Math.max(max, nums[from]);
        }
        else if (to - from == 1) {
            max = Math.max(max, nums[from]+nums[to]);
            max = Math.max(max, nums[from]);
            max = Math.max(max, nums[to]);
//            System.out.println(nums[from] + "  -  " + nums[to] + "   >> MAx = "+max);
            return max;
        }

//        if(to > nums.length-1) return Integer.MIN_VALUE;
//        if (from > to)
//            return Integer.MIN_VALUE;
//        // Base Case: Only one element
//        if (from == to)
//            return nums[from];

        int mid = (to  + from) / 2;


        int max1 = iterativeFind(nums, from, mid, max);
        int max2 = iterativeFind(nums, mid, to, max);


        max = Math.max(max1, max);
        max = Math.max(max2, max);

        return Math.max(sumArrayLeftRightMax(nums, from ,mid, to), max);
    }



//    public int maxSubArray(int[] nums) {
//
//        int max = Integer.MIN_VALUE;
//        for(int i=0; i < nums.length; i++) {
//            for(int j=i; j < nums.length; j++) {
//                int newMax = sumArray(nums, i, j);
//                if(newMax > max) {
//                    max = newMax;
//                }
//            }
//        }
//        return max;
//
//    }
//
    int sumArrayLeftRightMax(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=mid; i >= left; i--) {
            sum += nums[i];
            if(sum > leftSum) {
                leftSum = sum;
            }
//            System.out.print(nums[i]+",");
        }


//        System.out.print(" <====>");
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i=mid+1; i <= right; i++) {
            sum += nums[i];
            if(sum > rightSum) {
                rightSum = sum;
            }
//            System.out.print(nums[i]+",");
        }

        // System.out.print(" (sum)=" +maxSum + " ___ ");
        return Math.max((leftSum+rightSum), Math.max(rightSum, leftSum));
    }
}
