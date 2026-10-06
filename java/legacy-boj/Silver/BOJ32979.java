package Silver;

import java.util.Deque;
import java.util.Scanner;
import java.util.StringJoiner;

public class BOJ32979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // 참가자 수 n
        int t = sc.nextInt();
        sc.nextLine();
        // 게임 횟수 t
        StringJoiner sj = new StringJoiner(" ");

        Deque<Integer> d = new java.util.LinkedList<>();

        for (int i=0; i<2*n; i++){
            d.offer(sc.nextInt());
        }

        sc.nextLine();

        for (int i=0; i<t; i++){
            int num = sc.nextInt();
            num %= n*2;
            if (num==0){
                sj.add(Integer.toString(d.peekLast()));
                d.offerFirst(d.pollLast());
            }
            else {
                for (int j=0; j<num-1; j++){
                d.offer(d.poll());
                }
                sj.add(Integer.toString(d.peek()));
            }
        }

        System.out.println(sj);

        sc.close();
    }
}
