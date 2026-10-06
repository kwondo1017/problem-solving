package Bronze;

import java.util.Scanner;
import java.util.stream.IntStream;


public class BOJ1978 {
    static int sum = 0;

    public static Boolean isPrimeNumber(int num) {
        Boolean isPrime = true; //isPrime으로 소수 판별 및 반환
        if ( num == 1 ) return false; // 1은 소수가 아님

        // num이 주어졌을때 2부터 num루트까지의 수들로 모두 나눠보고 아니면 소수
        double doubleNum = num;
        double sqrt = Math.sqrt(doubleNum);
        int endNum = (int) Math.round(sqrt);

        // 2는 sqrt가 1.41이므로 endNum이 1이 되어 for문이 돌지 않음 -> 소수로 판별
        int[] arr = IntStream.rangeClosed(2, endNum).toArray();
        for(int x : arr){
            if(num % x == 0) isPrime = false;
        }

        return isPrime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        if(N < 0 || N > 100){
            System.out.println("범위 초과");
            sc.close();
            return;
        }

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            // 소수 판별
            if(isPrimeNumber(num)) sum++;
        }

        sc.close();
        System.out.println(sum);
    }
}
