package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16928_뱀과사다리게임 {
	
	static class info{
		int x, time;

		public info(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
	}
	
	static int [] map;
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int [101];
		visited = new boolean [101];
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //사다리 수
		int M = Integer.parseInt(st.nextToken()); // 뱀 수

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
		Queue<info> queue = new LinkedList<>();
	
		queue.add(new info(1,0));
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			if(temp.x==100) {
				System.out.println(temp.time);
				return;
			}
			
			for(int i=1;i<=6;i++) {
				int nx = temp.x+i;
				
				if(nx>=map.length || visited[nx]) continue;
				
				if(map[nx]!=0) queue.add(new info(map[nx],temp.time+1));
				else queue.add(new info(nx,temp.time+1));
				
				visited[nx] = true;
			}
		}
	}
}
