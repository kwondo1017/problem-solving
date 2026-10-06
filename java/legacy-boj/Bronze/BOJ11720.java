package Bronze;

import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String numbers = sc.nextLine();
        int result = 0;

        if(n < 1 || n > 100) {
            System.out.println("1부터 100 사이의 값을 입력해주세요.");
            sc.close();
            return;
        }
        
        try{
            for (int i = 0; i < n; i++) {
            char ch = numbers.charAt(i);
            int num = Integer.parseInt(String.valueOf(ch));
            result += num;
        }
        System.out.println(result);
        sc.close();
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            sc.close();
            return;
        }
    }
}
