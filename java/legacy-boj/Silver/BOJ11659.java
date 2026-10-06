package Silver;

import java.util.Scanner;

public class BOJ11659 {
    static int N;
    static int M;
    static int[] num;
    static int plus=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        num = new int[N+1];
        num[0] = 0;

        for(int i=1; i<=N; i++){
            plus += sc.nextInt();
            num[i] = plus;
        }

        sc.nextLine();

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            int sum = num[b] - num[a-1];
            
            System.out.println(sum);
        }

        sc.close();
    }
}
