package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int n;
    static int[] num;
    static int[] ops = new int[4]; // +, -, *, /
    static int minVal = Integer.MAX_VALUE;
    static int maxVal = Integer.MIN_VALUE;

    static public void dfs(int idx, int cur){
        if (idx == n) { // 숫자 N개 모두 사용 완료
        minVal = Math.min(minVal, cur);
        maxVal = Math.max(maxVal, cur);
        return;
        }

        int next = num[idx];

        // + 선택
        if (ops[0] > 0) {
            ops[0]--;
            dfs(idx + 1, cur + next);
            ops[0]++; // 되돌리기
        }

        // - 선택
        if (ops[1] > 0) {
            ops[1]--;
            dfs(idx + 1, cur - next);
            ops[1]++;
        }
        // * 선택
        if (ops[2] > 0) {
            ops[2]--;
            dfs(idx + 1, cur * next);
            ops[2]++;
        }
        // / 선택 (자바 int 나눗셈 규칙 그대로 사용)
        if (ops[3] > 0) {
            ops[3]--;
            dfs(idx + 1, cur / next);
            ops[3]++;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim()); 
        num = new int[n];

        String array = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(array);

        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        String op = br.readLine().trim();
        StringTokenizer st1 = new StringTokenizer(op);

        for (int j=0; j<4; j++){
            ops[j] = Integer.parseInt(st1.nextToken());
        }
        dfs(1, num[0]);
        System.out.println(maxVal);
        System.out.println(minVal);
    }
}
