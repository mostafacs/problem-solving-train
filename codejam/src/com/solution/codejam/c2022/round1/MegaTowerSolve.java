package com.solution.codejam.c2022.round1;

import java.io.OutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.PrintWriter;
        import java.io.PrintStream;
        import java.util.Arrays;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class MegaTowerSolve {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        LetterBlocks solver = new LetterBlocks();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class LetterBlocks {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            long time = System.currentTimeMillis();
            out.printf("Case #%d: ", testNumber);
            solveOne(in, out);
            System.err.printf("Test #%d solved in %d ms\n", testNumber, System.currentTimeMillis() - time);
        }

        public void solveOne(FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = in.next();
            }
            for (int i = 0; i < n; i++) {
                String s = input[i];
                if (s.charAt(0) == s.charAt(s.length() - 1)) {
                    for (int j = 0; j < n; j++) {
                        if (i != j && input[j] != null) {
                            if (input[j].charAt(0) == s.charAt(0)) {
                                input[j] = s + input[j];
                                input[i] = null;
                                break;
                            }
                            if (input[j].charAt(input[j].length() - 1) == s.charAt(0)) {
                                input[j] = input[j] + s;
                                input[i] = null;
                                break;
                            }
                        }
                    }
                }
            }
//        System.err.println(Arrays.toString(input));
            List<String> s = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String cur = input[i];
                if (cur == null) {
                    continue;
                }
                while (true) {
                    boolean found = false;
                    for (String t : s) {
                        if (t.charAt(0) == cur.charAt(cur.length() - 1)) {
                            cur = cur + t;
                            s.remove(t);
                            found = true;
                            break;
                        }
                        if (t.charAt(t.length() - 1) == cur.charAt(0)) {
                            cur = t + cur;
                            s.remove(t);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        s.add(cur);
                        break;
                    }
                }
            }
            String ans = "";
            for (String t : s) {
                ans += t;
            }
            if (!good(ans)) {
                ans = "IMPOSSIBLE";
            }
            out.println(ans);
        }

        boolean good(String cur) {
            int[] min = new int[26], max = new int[26], count = new int[26];
            Arrays.fill(min, -1);
            Arrays.fill(max, -2);
            for (int pos = 0; pos < cur.length(); pos++) {
                int ch = cur.charAt(pos) - 'A';
                if (min[ch] == -1) {
                    min[ch] = max[ch] = pos;
                } else {
                    max[ch] = pos;
                }
                count[ch]++;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] != max[i] - min[i] + 1) {
                    return false;
                }
            }
            return true;
        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (line == null) {
                    throw new UnknownError();
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}


