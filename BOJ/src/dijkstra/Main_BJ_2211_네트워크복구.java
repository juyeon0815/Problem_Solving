package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_BJ_2211_네트워크복구 {
	
	public static class Node {
		int v,w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int N,M;
	static int [] distance;
	static boolean [] visited;
	static List<Node> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		distance = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<N+1; i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,price));
			list[end].add(new Node(start,price));
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[1] = 0; //시작점 = 슈퍼컴퓨터
		
		int min, current =0;
		for(int i=0;i<N;i++) {
			min = Integer.MAX_VALUE;
			current = -1;
			for(int j=1;j<N+1;j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			
			for(Node next : list[current]) {
				if(!visited[next.v] && distance[next.v]> distance[current]+next.w){
					distance[next.v] = distance[current]+next.w;
					hm.put(next.v, current);
				}
			}
			visited[current] = true;
		}
	
		sb.append(hm.size()+"\n");
		for(Entry<Integer,Integer> entrySet : hm.entrySet()) {
			sb.append(entrySet.getValue()+" "+entrySet.getKey()+"\n");
		}
		System.out.println(sb.toString());
	}

}
