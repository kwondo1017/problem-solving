package Silver;

import java.util.Scanner;

public class BOJ10211 {
    static int T;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            sc.nextLine();

            int maxSum = arr[0];
            int currentSum = arr[0];

            for (int i = 1; i < N; i++) {
                currentSum = Math.max(arr[i], currentSum + arr[i]);
                maxSum = Math.max(maxSum, currentSum);
            }

            System.out.println(maxSum);
        }
        sc.close();
    }
}

