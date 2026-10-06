package Bronze;

import java.util.Scanner;

public class BOJ2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        if(n < 1 || n > 1000) {
            System.out.println("초기값 범위 초과");
            sc.close();
            return;
        }

        try {
            for (int i = 0; i < n; i++){
                String input = sc.nextLine();
                int testInteger = Integer.parseInt(input.substring(0, 1));

                if(testInteger < 1 || testInteger > 8) {
                    System.out.println("testInteger 범위 초과");
                    sc.close();
                    return;
                }

                for(int j = 2; j < input.length(); j++){
                    for(int o = 0; o < testInteger; o++){
                        System.out.print(input.charAt(j));
                    }
                }
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            sc.close();
            return;
        }
        
        sc.close();
    }
}
