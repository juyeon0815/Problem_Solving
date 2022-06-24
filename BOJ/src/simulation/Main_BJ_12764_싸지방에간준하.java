package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_12764_싸지방에간준하 {
	
	static class Info{
		int start, end;

		public Info(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static class Seat{
		int time, index;

		public Seat(int time, int index) {
			this.time = time;
			this.index = index;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.start-o2.start;
			}
		});
		
		PriorityQueue<Seat> seat = new PriorityQueue<>(new Comparator<Seat>() {

			@Override
			public int compare(Seat o1, Seat o2) {
				return o1.time-o2.time;
			}
		});
		
		PriorityQueue<Integer> index = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		
		int [] computer = new int[100001];
		int nowIndex = 1;
		
		while(!pq.isEmpty()) {
			Info temp = pq.poll();

			//빈자리 체크
			while(!seat.isEmpty() && seat.peek().time<=temp.start) {
				index.add(seat.poll().index);
			}
			
			//빈자리가 없을 경우
			if(index.isEmpty()) {
				seat.add(new Seat(temp.end, nowIndex));
				computer[nowIndex]++;
				nowIndex++;
			}
			//빈자리가 있을 경우
			else {
				int num = index.poll();
				seat.add(new Seat(temp.end,num));
				computer[num]++;
			}
			
		}
		
		int cnt=0;
		for(int i=1;i<computer.length;i++) {
			if(computer[i]==0) break;
			
			cnt++;
			sb.append(computer[i]+" ");
		}
		
		System.out.println(cnt);
		System.out.println(sb.toString());

	}

}
