package first_semester;

import java.util.*;

public class Main {
	static int K;
	static int shake(int[] scoville, int K) {
		int cnt = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(scoville.length);
		for(int i = 0; i < scoville.length; i++) queue.offer(scoville[i]);
		while(queue.size() > 1) {
			if(queue.peek() > K) return cnt;
			int min = queue.poll();
			int second_min = queue.poll();
			queue.offer(min + 2*(second_min));
			cnt++;
		}
		if(queue.peek() < K) return -1;
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scoville = {1, 2, 3, 9, 10, 12};
		K = sc.nextInt();
		System.out.println(shake(scoville, K));
		sc.close();
	}
}
