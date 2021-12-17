package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1916_최소비용구하기 {
	
	static class info{
		int end, price;

		public info(int end, int price) {
			super();
			this.end = end;
			this.price = price;
		}
	}
	
	static ArrayList<info> list[];
	static boolean [] visited;
	static int [] distance;
	static int N,M,start, end,INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //도시 수
		M = Integer.parseInt(br.readLine()); //버스 수
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		distance = new int[N+1];
		
		Arrays.fill(distance, INF);
		
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			list[start].add(new info(end,price));
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		distance[start] = 0;
		
		dijkstra();
		System.out.println(distance[end]);
	}
	
	public static void dijkstra() {
		int min, current = 0;
		for(int i=0;i<N;i++) {
			min = Integer.MAX_VALUE;
			for(int j=1;j<N+1;j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			
			for(info temp : list[current]) {
				if(!visited[temp.end] && distance[temp.end]>distance[current]+temp.price) {
					distance[temp.end]=distance[current]+temp.price;
				}
			}
			visited[current] = true;
		}
	}

}
