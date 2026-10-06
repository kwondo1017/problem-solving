package Gold;

import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

public class BOJ2696 {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 (작은 값들)
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙 (큰 값들)

    static void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num); // 작은 값은 maxHeap으로
        } else {
            minHeap.offer(num); // 큰 값은 minHeap으로
        }

        // 힙 크기 균형 맞추기
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // maxHeap에서 하나 minHeap으로
        } 
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // minHeap에서 하나 maxHeap으로
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        for(int i=0; i<n; i++){
            int size = Integer.parseInt(br.readLine().trim());
            System.out.println((size+1)/2);

            String test = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(test);

            for (int j=0; j<size; j++){
                int a = Integer.parseInt(st.nextToken());
                addNum(a);
                if (j%2==0) {
                    System.out.print(maxHeap.peek());
                    if (j<size-1) {
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}
// 이제 입력이랑 출력 10개 제한만 해결하면 끝

