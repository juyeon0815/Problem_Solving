package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1240_노드사이의거리 {
	
	static class Node {
		int end, distance;

		public Node(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}	
	}
	
	static int N,M;
	static long answer;
	static int[] distance;
	static List<Node> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //노드개수
		M = Integer.parseInt(st.nextToken()); //노드 쌍
		
		list = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, distance));
			list[end].add(new Node(start, distance));
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			distance = new int[N+1];
			
			System.out.println(bfs(start,end));
		}
	}
	
	public static int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(Node item : list[temp]) {
				if(distance[item.end]!=0) continue;
				distance[item.end] = distance[temp] + item.distance;
				queue.add(item.end);
			}
		}
		
		return distance[end];
	}
}
