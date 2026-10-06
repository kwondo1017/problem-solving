package Silver;

import java.util.Scanner;

public class BOJ15649 {
    static int n;
    static int m;

    static int[] selected;
    static boolean[] used;

    static void dfs(int depth){
        if (depth == m) {
            print();
            return;
        }

        for(int i=1; i<=n; i++){
            if (used[i]) continue;

            used[i] = true;
            selected[depth]=i;

            dfs(depth+1);

            used[i] = false;
        }
    }

    static void print(){
        for(int i=0; i<m; i++){
            System.out.print(selected[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.close();

        selected = new int[m];
        used = new boolean[n+1];

        dfs(0);
    }
}
