package Bronze;

import java.util.Scanner;

public class BOJ1152 {
    public static String myTrim(String str){
        if(str == null || str.length() == 0) return "";

        int start = 0;
        int end = str.length();
        while (start <= str.length()){
            if (str.charAt(start) != ' ') break;
            start++;
        }

        while (end > 0){
            if (str.charAt(end - 1) != ' ') break;
            end--;
        }

        return str.substring(start, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();


        if(str.isEmpty() || str.isBlank()){
            System.out.println(0);
            return;
        }
        // str은 공백만 있지않고 비어있지도 않음
        // 단어 최소 1개 존재
        int sum = 1;
        str = myTrim(str); // 양쪽 공백 제거

        for(int x=0; x<str.length(); x++){
            char ch = str.charAt(x);
            if(ch == ' ') sum += 1;
        }
        System.out.println(sum);
    }
}

