package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1520_내리막길 {
	
	static int N,M, count=0;
	static int [][] map, route;
	
	static int [] dx= {-1,0,1,0};
	static int [] dy= {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		route = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				route[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	public static int dfs(int x, int y) {
		if(x==N-1 && y==M-1) {
			return 1 ;
		}
		
		if(route[x][y]!=-1) return route[x][y];
		
		route[x][y]=0;
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(range(nx,ny)&&map[nx][ny]<map[x][y]) {
				route[x][y]+=dfs(nx,ny);
			}
		}
		return route[x][y];
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
