package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_21938_영상처리 {
	
	static int N,M;
	static double [][] map;
	static boolean [][] visited;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static Queue<int []> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new double[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))/3;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>=T) map[i][j] = 255;
				else map[i][j] = 0;
			}
		}
		
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==255 && !visited[i][j]) {
					count++;
					bfs(i,j);
				}
			}
		}
		System.out.println(count);

	}
	public static void bfs(int x, int y) {
		visited[x][y] = true;
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && map[nx][ny]==255 && !visited[nx][ny] ) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
				}
				
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
