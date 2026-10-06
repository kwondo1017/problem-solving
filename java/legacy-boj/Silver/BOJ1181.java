package Silver;

import java.util.Arrays;
import java.util.HashSet;

import java.util.Scanner;

public class BOJ1181 {
    static int N;
    static String[] str;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<N; i++){
            set.add(sc.nextLine());
        }
        sc.close();

        str = set.toArray(new String[set.size()]);
        Arrays.sort(str);
        Arrays.sort(str, (String a, String b) -> a.length() - b.length());

        for(int i=0; i<str.length; i++){
            System.out.println(str[i]);
        }
    }
}