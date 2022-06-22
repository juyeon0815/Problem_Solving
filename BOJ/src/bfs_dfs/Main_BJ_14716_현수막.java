package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14716_현수막 {
	
	static int M,N;
	static int [][] map;
	
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		
		map = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int cnt =0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					map[i][j] = 0;
					bfs(i,j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		

	}
	
	public static void bfs(int x, int y) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<8;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && map[nx][ny]==1) {
					queue.add(new int[] {nx,ny});
					map[nx][ny] = 0;
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}

}
