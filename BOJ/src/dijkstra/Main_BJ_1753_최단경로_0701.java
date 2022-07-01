package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로_0701 {
	
	static class Info{
		int end, price;

		public Info(int end, int price) {
			this.end = end;
			this.price = price;
		}		
	}
	
	static int V,E,K;
	static ArrayList<Info> list[];
	static int [] distance;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		distance = new int[V+1];
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i=1;i<V+1;i++) list[i] = new ArrayList<>();
		
		K = Integer.parseInt(br.readLine());
		
		reset();
		
		distance[K] = 0;
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Info(end,weight));
		}
		
		dijkstra();
		for(int i=1;i<distance.length;i++) {
			if(distance[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
		System.out.println(sb.toString());
		
	}
	
	public static void reset() {
		for(int i=1;i<distance.length;i++) distance[i] = Integer.MAX_VALUE;
	}
	
	public static void dijkstra() {
		
		int min, current =0;
		for(int i=0;i<V;i++) { //정점 수
			min = Integer.MAX_VALUE;
			current = -1;
			
			for(int j=1;j<=V;j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			
			if(current==-1) break;
			
			for(Info item : list[current]) {
				if(!visited[item.end] && distance[item.end] > distance[current]+ item.price) {
					distance[item.end] = distance[current]+ item.price;
				}	
			}
			visited[current] = true;	
		}
		
	}

}
