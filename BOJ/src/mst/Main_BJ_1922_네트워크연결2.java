package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1922_네트워크연결2 {
	
	static class Node implements Comparable<Node>{
		int start, end, price;

		public Node(int start, int end, int price) {
			super();
			this.start = start;
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return this.price-o.price;
		}
		
	}
	
	static int N,M;
	static int [] parents;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //컴퓨터의 수
		M = Integer.parseInt(br.readLine()); //연결할 수 있는 선의 수
		
		parents = new int[N+1];
		
		for(int i=1;i<parents.length;i++) parents[i]=i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(start,end,price));
		}
		
		connection();
	}
	
	public static void connection() {
		int count=1, answer=0;
		while(count<N) {
			Node temp = pq.poll();
			if(!union(temp.start,temp.end)) {
				answer+=temp.price;
				count++;
			}
		}
		System.out.println(answer);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return true;
		
		if(aRoot>bRoot) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
		return false;
	}
	
	public static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}

}
