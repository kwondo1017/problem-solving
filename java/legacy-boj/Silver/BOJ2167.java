package Silver;

import java.util.Scanner;

public class BOJ2167 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] prefix_sum;
    static int [] ijxy = new int[4];

    static int result;

    static int K;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        arr = new int[N][M];
        prefix_sum = new int[N+1][M+1];

        for (int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        K = sc.nextInt();
        sc.nextLine();

        for(int i=1; i<=N;i++){
            for(int j=1; j<=M; j++){
                prefix_sum[i][j] = prefix_sum[i][j - 1] + prefix_sum[i - 1][j] - prefix_sum[i - 1][j - 1] + arr[i - 1][j - 1];
            }
        }

        for (int i=0; i<K; i++){
            for (int j=0; j<4; j++){
                ijxy[j] = sc.nextInt();
            }
            sc.nextLine();

            result = prefix_sum[ijxy[2]][ijxy[3]] - prefix_sum[ijxy[2]][ijxy[1]-1] - prefix_sum[ijxy[0]-1][ijxy[3]] + prefix_sum[ijxy[0]-1][ijxy[1]-1];

            System.out.println(result);
        }

        sc.close();
    }
}
