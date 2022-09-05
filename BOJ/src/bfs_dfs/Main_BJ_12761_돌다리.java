package bfs_dfs;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_BJ_12761_돌다리 {
	
	static class info{
		int position, moveCount;

		public info(int position, int moveCount) {
			super();
			this.position = position;
			this.moveCount = moveCount;
		}
	}
	
	static int A,B,N,M;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //출발
		M = Integer.parseInt(st.nextToken()); //도착
		
		visited = new boolean[100001];
		
		Queue<info> queue = new LinkedList<>();
		queue.add(new info(N,0));
		visited[N] = true;
		
		int [] dx = {-1,1,-A,A,-B,B};
		int [] jump = {A,B};
		
		
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			if(temp.position==M) {
				System.out.println(temp.moveCount);
				break;
			}
			
			for(int i=0;i<6;i++) {
				int nx = temp.position+dx[i];
				
				if(!range(nx) || visited[nx]) continue;
				
				queue.add(new info(nx,temp.moveCount+1));
				visited[nx] = true;
			}
			
			for(int i=0;i<2;i++) {
				int nx = temp.position*jump[i];
				
				if(!range(nx) || visited[nx]) continue;
				
				queue.add(new info(nx,temp.moveCount+1));
				visited[nx] = true;
			}
		}

	}
	
	public static boolean range(int x) {
		return x>=0 && x<visited.length;
	}

}
