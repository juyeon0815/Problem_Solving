package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_BJ_1753_최단경로_PQ_0701 {
	
	static class Info implements Comparable<Info>{
		int end, weight;

		public Info(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info o) {
			return this.weight-o.weight;
		}
	}
	
	static int V,E,K;
	static int [] distance;
	static boolean [] visited;
	static ArrayList<Info> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		list = new  ArrayList[V+1];
		
		for(int i=1;i<=V;i++) list[i] = new  ArrayList<>();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=1;i<V+1;i++) distance[i] = Integer.MAX_VALUE;
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Info(end,weight));
		}
		
		distance[K] = 0;
		dijkstra(K);
		for(int i=1;i<distance.length;i++) {
			if(distance[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start,0));
		
		while(!pq.isEmpty()) {
			Info item = pq.poll();
			
			if(!visited[item.end]) {
				for(Info temp : list[item.end]) {
					if(distance[temp.end]> distance[item.end]+ temp.weight) {
						distance[temp.end] = distance[item.end]+ temp.weight;
						pq.add(new Info(temp.end,distance[temp.end]));
					}
				}
			}
			
			visited[item.end] = true;
		}
	}

}
