package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16929_TwoDots {
	
	
	static int N,M, startX, startY;
	static char [][] map;
	static boolean [][] visited;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited = new boolean[N][M];
				startX = i; startY = j;
				if(dfs(i,j,1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");

	}
	
	public static boolean dfs(int x, int y, int count) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(range(nx,ny) && map[x][y]== map[nx][ny]) {
				if(count>=4 && startX == nx && startY == ny) return true;
				else if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					if(dfs(nx,ny,count+1)) return true;
				}
			}
		}
		return false;
	}
	
	public static boolean range(int x ,int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
