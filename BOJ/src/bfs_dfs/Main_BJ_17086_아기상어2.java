package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main_BJ_17086_아기상어2 {
	
	public static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M, answer=Integer.MIN_VALUE;
	static int [][] map, distance;
	static Queue<Position> queue= new LinkedList<>();
	
	static int [] dx = {-1,-1,-1,0,1,1,1,0};
	static int [] dy = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		distance = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					queue.add(new Position(i,j));
				}
			}
		}
		
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Position temp = queue.poll();
			
			for(int i=0;i<8;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(!range(nx,ny) || distance[nx][ny]!=0 || map[nx][ny]==1) continue;
				distance[nx][ny] = distance[temp.x][temp.y] +1;
				answer = Math.max(answer, distance[nx][ny]);
				queue.add(new Position(nx, ny));
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
}
