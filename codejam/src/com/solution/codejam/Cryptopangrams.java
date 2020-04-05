package com.solution.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Cryptopangrams {

    private static final char[] ALPHAPET = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                BigInteger maxPrime = scanner.nextBigInteger();
                int seqLength = scanner.nextInt();
                BigInteger[] seq = new BigInteger[seqLength];
                for (int i = 0; i < seqLength; i++) {
                    seq[i] = scanner.nextBigInteger();
                }
                String result = solve(maxPrime, seq);
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
    }

    static String solve(BigInteger maxPrime, BigInteger[] seq) {

        HashSet primes = new HashSet();

        BigInteger[] valuesExpanded= new BigInteger[seq.length + 1];

        BigInteger commonBigInt = seq[1].gcd(seq[0]);
        BigInteger number1 = seq[0].divide(commonBigInt);

        // BigInteger common = commonBigInt;

        primes.add(number1);
        primes.add(commonBigInt);
        valuesExpanded[0] = number1;
        valuesExpanded[1] = commonBigInt;

        for (int i = 1; i < seq.length; i++) {
            valuesExpanded[i+1] = seq[i].divide(commonBigInt);
            commonBigInt = valuesExpanded[i+1];
            primes.add(commonBigInt);
        }

        BigInteger[] sortedPrimes = new BigInteger[primes.size()];
        primes.toArray(sortedPrimes);


        Arrays.sort(sortedPrimes);

        Map<BigInteger, Character> dictionary = new HashMap<>();
        for (int i = 0; i < sortedPrimes.length; i++) {
            dictionary.put(sortedPrimes[i], ALPHAPET[i]);
        }


        char[] decoded = new char[valuesExpanded.length];
        for (int i = 0; i < valuesExpanded.length; i++) {
            decoded[i] = dictionary.get(valuesExpanded[i]);
        }


        return  String.valueOf(decoded);

    }
}
