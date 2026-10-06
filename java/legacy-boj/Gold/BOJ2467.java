package Gold;

import java.util.Scanner;

public class BOJ2467 {
    static int N;
    static int[] num;

    static int minVal;
    static int right;
    static int left;
    static int[] ans;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        num = new int[N];

        left = 0;
        right = N-1;

        for (int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }
        sc.close();

        minVal = Math.abs(num[right]+num[left]);
        int[] ans = {num[left], num[right]};

        while (left != right) {
            if (minVal > Math.abs(num[right]+num[left])) {
                minVal = Math.abs(num[right]+num[left]);
                ans[0] = num[left];
                ans[1] = num[right];
            }

            if (num[right] + num[left] >= 0) 
                right -= 1;
            else if (num[right]+num[left] <= 0) 
                left += 1;
        }

        String join_ans = ans[0]+ " " + ans[1];

        System.out.println(join_ans);
    }
}
