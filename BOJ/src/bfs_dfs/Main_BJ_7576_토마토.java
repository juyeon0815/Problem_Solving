package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7576_토마토 {
	
	static int N,M, min=0;
	static int [][] map;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static Queue<int []> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) queue.add(new int[] {i,j});
			}
		}
		
		bfs();
		
		boolean flag = true;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					flag = false;
					break;
				}
				min = Math.max(min, map[i][j]);
			}
		}
		
		if(flag) System.out.println(min-1);
		else System.out.println(-1);

	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && map[nx][ny]==0) {
					map[nx][ny] = map[temp[0]][temp[1]]+1;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
