package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로_PQ {
	
	static class info implements Comparable<info>{
		int end, weight;

		public info(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(info o) {
			return this.weight-o.weight;
		}
		
	}
	
	static int V,E;
	static int [] distance;
	static ArrayList<info> node[];
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new int[V+1];
		node = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i=1;i<distance.length;i++) node[i] = new ArrayList<>();
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i=1;i<distance.length;i++) distance[i] = Integer.MAX_VALUE;
		distance[start] = 0;
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int go = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			node[go].add(new info(end,value));
		}
		
		dijkstra(start);
		
		for(int i=1;i<distance.length;i++) {
			if(distance[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
		System.out.println(sb.toString());

	}
	
	public static void dijkstra(int start) {
		PriorityQueue<info> pq = new PriorityQueue<>();
		pq.add(new info(start,0));
		
		while(!pq.isEmpty()) {
			info temp = pq.poll();
			
			if(!visited[temp.end]) {
				for(info item : node[temp.end]) {
					if(distance[item.end]> distance[temp.end]+item.weight) {
						distance[item.end]=distance[temp.end]+item.weight;
						pq.add(new info(item.end,distance[item.end]));
					}
				}
				visited[temp.end] = true;
			}
		}
		
	}

}
