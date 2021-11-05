package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로 {
	
	static class info{
		int end, weight;

		public info(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
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
		
		dijkstra();
		
		for(int i=1;i<distance.length;i++) {
			if(distance[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
		System.out.println(sb.toString());

	}
	
	public static void dijkstra() {
		int min, current = 0;
		
		for(int i=0;i<V;i++) {
			min = Integer.MAX_VALUE;
			current = -1;
			for(int j=1;j<V+1;j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			if(current == -1) break;
			
			for(info temp : node[current]) {
				if(!visited[temp.end] && distance[temp.end]>distance[current]+temp.weight) {
					distance[temp.end]=distance[current]+temp.weight;
				}
			}
			visited[current] = true;
		}
		
	}

}
