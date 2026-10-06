package Bronze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            list.add(sc.nextInt());
            if (list.get(i) < -1000000 || list.get(i) > 1000000) {
                System.out.println("범위 초과");
                sc.close();
                return;
            }
        }

        if(n < 1 || n > 1000000) {
            System.out.println("범위 초과");
            sc.close();
            return;
        }

        Collections.sort(list);
        System.out.printf("%d %d\n", list.get(0), list.get(n - 1));
        sc.close();
    }
}
