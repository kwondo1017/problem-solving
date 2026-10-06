package Silver;

import java.util.Scanner;
import java.util.Stack;

public class BOJ12789 {
    public static void main(String[] args) {
        // 메인 스택과 보조 스택을 이용해 1-n까지 순서대로 출력이 가능하면 nice
        // 불가능하면 SAD를 출력

        Stack<Integer> subStack = new Stack<>(); // 옆 공간 스택

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        if(n < 1 || n > 1000){
            System.out.println("n 범위초과");
            sc.close();
            return;
        }

        int cnt = 1;
        for (int i=0; i<n; i++){
            int num = sc.nextInt();

            while (!subStack.empty() && subStack.peek() == cnt){
                subStack.pop();
                cnt++;
            }

            if(num == cnt)
                cnt++;
            else
                subStack.push(num);
        }

        while (!subStack.empty() && subStack.peek() == cnt){
            subStack.pop();
            cnt++;
        }

        System.out.println((cnt == n + 1) ? "Nice" : "Sad");
        sc.close();
    }
}
