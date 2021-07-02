package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1922_네트워크연결 {
	
	static class Node implements Comparable<Node>{
		int start, end, weight;

		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	
	static int N,M;
	static int [] node;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine()); //컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 선의 수
		
		node = new int[N+1];
		for(int i=1;i<N+1;i++) node[i] =i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a,b,w));
		}
		
		int count=1, ans=0;
		while(count<N) {
			Node node = pq.poll();
			if(union(node.start,node.end)) {
				ans+=node.weight;
				count++;
			}
		}
		System.out.println(ans);

	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		
		if(aRoot>bRoot) node[aRoot] = bRoot;
		else node[bRoot] = aRoot;
		return true;
	}
	
	public static int find(int a) {
		if(node[a]==a) return a;
		return node[a] = find(node[a]);
	}

}
