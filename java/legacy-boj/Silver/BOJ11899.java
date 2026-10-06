package Silver;

import java.util.Scanner;

public class BOJ11899 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        sc.close();

        int left = 0; // 이전까지 해소되지않은 (의 수
        int right = 0; // 이전까지 해소되지않은 )의 개수

        for (int i=0; i<n.length(); i++){
            char ch = n.charAt(i);
            
            if (ch == ')') {
                if (left>0) left--;
                else right++;
            }

            if (ch == '(') left++;
        }

        System.out.println(left+right);
    }
}
