package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1446_지름길 {
	
	static class Node {
		int end, length;

		public Node(int end, int length) {
			this.end = end;
			this.length = length;
		}
	}
	
	static int N,D,INF = Integer.MAX_VALUE;
	static List<Node> list[];
	static int [] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		list = new List[10001];
		distance = new int[10001];
		
		for(int i=0;i<list.length;i++) {
			distance[i] = i;
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,length));
		}
		
		dijkstra(0);
		System.out.println(distance[D]);

	}
	
	public static void dijkstra(int start) {
		// 도착지 넘으면
		if(start > D) return;
		
		if(distance[start+1] > distance[start]+1) distance[start+1] = distance[start] + 1;
		
		for(int i=0;i<list[start].size();i++) {
			if(distance[start] + list[start].get(i).length < distance[list[start].get(i).end]) distance[list[start].get(i).end] = distance[start] + list[start].get(i).length;
		}
		
		dijkstra(start+1);
	}
}
