package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1895 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine().trim();

        StringTokenizer st = new StringTokenizer(size); //StringTokenizer인자값에 입력 문자열 넣음
        int a = Integer.parseInt(st.nextToken()); //첫번째 호출
        int b = Integer.parseInt(st.nextToken()); //두번째 호출

        int[][] image = new int[a][b];

        for(int i=0; i<image.length; i++){
            String s = br.readLine();
            StringTokenizer str = new StringTokenizer(s);
            for (int j=0; j<image[i].length; j++){
                int x = Integer.parseInt(str.nextToken());
                image[i][j] = x;
            }
        }

        int t = Integer.parseInt(br.readLine().trim());
        int sum = 0;  
        
        for (int i = 0; i < a - 2; i++) { 
            for (int j = 0; j < b - 2; j++) {
                List<Integer> l = new ArrayList<>(); 

                for (int x = i; x <= i + 2; x++) {
                    for (int y = j; y <= j + 2; y++) {
                        l.add(image[x][y]);
                    }
                }
                Collections.sort(l);
                if (l.get(l.size() / 2)>=t) {
                    sum++;
                } 
            }
        }

        System.out.println(sum);
    }
}