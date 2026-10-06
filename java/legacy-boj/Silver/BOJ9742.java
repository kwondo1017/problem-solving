package Silver;

import java.io.*;
import java.util.*;

public class BOJ9742 {
    static boolean nextPermutation(char[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;

        int j = a.length - 1;
        while (a[i] >= a[j]) j--;

        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

        int l = i + 1, r = a.length - 1;
        while (l < r) {
            tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++; r--;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            out.append(s).append(" ").append(n).append(" = ");

            char[] arr = s.toCharArray();
            Arrays.sort(arr); // 사전순 시작점

            if (n <= 0) {
                out.append("No permutation\n");
                continue;
            }

            if (n == 1) {
                out.append(new String(arr)).append("\n");
                continue;
            }

            boolean ok = true;
            for (int k = 1; k < n; k++) { // 현재가 1번째이므로 n-1번 nextPermutation
                if (!nextPermutation(arr)) {
                    ok = false;
                    break;
                }
            }

            if (ok) out.append(new String(arr)).append("\n");
            else out.append("No permutation\n");
        }

        System.out.print(out.toString());
    }
}