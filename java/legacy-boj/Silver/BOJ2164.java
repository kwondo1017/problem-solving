package Silver;

import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        Deque<Integer> d = new java.util.LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if(n < 1 || n > 500000){
            System.out.println("n 범위초과");
            return;
        }

        List<Integer> num = new ArrayList<>();

        for(int i=1; i<=n; i++){
            num.add(i);
        }

        d.addAll(num);

        while (true){
            if (d.size() == 1) {
                System.out.println(d.peek());
                break;
            }

            d.poll();
            d.offer(d.poll());
        }
    }
}
