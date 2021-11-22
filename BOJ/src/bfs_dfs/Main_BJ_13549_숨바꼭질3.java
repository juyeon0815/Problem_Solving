package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_13549_숨바꼭질3 {
	
	static class info implements Comparable<info>{
		int position, time;

		public info(int position, int time) {
			super();
			this.position = position;
			this.time = time;
		}

		@Override
		public int compareTo(info o) {
			return this.time-o.time;
		}
	}
	
	static int N,K;
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];
		
		move();
	}
	
	public static void move() {
		Queue<info> pq = new LinkedList<>();
		
		pq.add(new info(N,0));
		
		while(!pq.isEmpty()) {
			info temp = pq.poll();
			
			if(temp.position == K) {
				System.out.println(temp.time);
				return;
			}
			
			int nx = 0;
			for(int i=0;i<3;i++) {
				if(i==0) nx = temp.position*2;
				else if(i==1) nx = temp.position-1;
				else if(i==2) nx = temp.position+1;
				
				if(range(nx) && !visited[nx]) {
					if(i==1 || i==2) pq.add(new info(nx, temp.time+1));
					else pq.add(new info(nx, temp.time));
					visited[nx] = true;
				}
			}
		}
	}
	
	public static boolean range(int x) {
		return x>=0 && x<visited.length;
	}

}
