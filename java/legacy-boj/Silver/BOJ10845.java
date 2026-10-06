package Silver;

import java.util.Queue;
import java.util.Scanner;

public class BOJ10845 {

    public static int qBack(Queue<Integer> queue) {
        if(queue.isEmpty()) 
            return -1;

        int size = queue.size();
        int[] saveQ = new int[size];

        for (int j=0; j<size; j++){
            saveQ[j] = queue.poll();
        }

        for (int i=0; i<size; i++){
            queue.offer(saveQ[i]);
        }

        return saveQ[size-1];
    }

    public static void main(String[] args) {
        Queue<Integer> q = new java.util.LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        if(n < 1 || n > 10000){
            System.out.println("n 범위초과");
            sc.close();
            return;
        }

        for (int i=0; i<n; i++){
            String order = sc.next();

            switch (order) {
                case "push": 
                    int pushX = sc.nextInt();
                    q.offer(pushX);
                    break;

                case "pop": 
                    if(q.isEmpty()) 
                        System.out.println(-1);
                    else
                        System.out.println(q.poll());
                    break;

                case "size":
                    System.out.println(q.size()); 
                    break;

                case "empty":
                    System.out.println((q.isEmpty()) ? 1 : 0);
                    break;

                case "front":
                    if(q.isEmpty()) 
                        System.out.println(-1);
                    else
                        System.out.println(q.peek());
                    break;

                case "back":
                    System.out.println(qBack(q));
                    break;
            }
        }

        sc.close();
    }
}
