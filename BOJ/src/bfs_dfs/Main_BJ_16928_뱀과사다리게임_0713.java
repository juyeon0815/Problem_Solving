package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16928_뱀과사다리게임_0713 {
	
	static int N,M;
	static int [] map;
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[101];
		visited = new boolean[101];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x] = y;
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u] = v;
		}
		bfs();
	}
	
	public static void bfs() {
		Queue<int []> queue = new LinkedList<>();
		
		queue.add(new int[] {1,0});
		
		while(!queue.isEmpty()) {
			int [] item = queue.poll();
			
			if(item[0]==100) {
				System.out.println(item[1]);
				return;
			}
			
			for(int i=1;i<=6;i++) {
				int nx = item[0] + i;
				
				if(nx>=map.length || visited[nx]) continue;
				
				if(map[nx]!=0) queue.add(new int[] {map[nx],item[1]+1});
				else queue.add(new int[] {nx,item[1]+1});
				
				visited[nx] = true;
			}
		}
	}

}
