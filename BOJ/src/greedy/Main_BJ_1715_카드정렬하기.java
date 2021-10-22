package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_BJ_1715_카드정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for(int i=0;i<N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int sum=0;
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			sum+=a+b;
			pq.add(a+b);
		}
		System.out.println(sum);
	}

}
