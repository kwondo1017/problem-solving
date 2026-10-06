package Gold;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1931 {
    static int N;
    static int[][] T;
    static int cnt = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        T = new int[N][2];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            String[] parts = s.split(" ");
            T[i][0] = Integer.parseInt(parts[0]);
            T[i][1] = Integer.parseInt(parts[1]);
        }

        Arrays.sort(T, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]); 
        });

        int end = 0;

        for (int i = 0; i < N; i++) {
            int start = T[i][0];
            int finish = T[i][1];

            if (start >= end) {   
                cnt++;
                end = finish; 
            }
        }

        System.out.println(cnt);
    }
}
