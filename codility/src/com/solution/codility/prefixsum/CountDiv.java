package com.solution.codility.prefixsum;

/**
 * @Author Mostafa
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 * Because division represent distribution process. we can simply use division.
 */
public class CountDiv {

    public static void main(String[] args) {

        int A = 6, B = 11, K = 2;

        System.out.println(new CountDiv().solution(A, B, K));
    }

    public int solution(int A, int B, int K) {

        int count = 0;

        int r1 = A / K; // distribution of 0 to A element on K item [[ count of numbers accept division on K without reminder from 0 to A ]]
        int r2 = B / K; // distribution of 0 to B element on K item [[ count of numbers accept division on K without reminder from 0 to B ]]


        count += r2 - r1; // exclude r1 counts

        if( A  % K == 0) count++;

        return count;
    }

}
