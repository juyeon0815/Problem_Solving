package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16948_데스나이트 {
	
	static class info{
		int x,y, move;

		public info(int x, int y, int move) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
		}
		
	}
	
	static int N, startX, startY, arriveX, arriveY;
	static int [] dx = {-2,-2,0,0,2,2};
	static int [] dy = {-1,1,-2,2,-1,1};
	static int [][] map;
	static Queue<info> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		arriveX = Integer.parseInt(st.nextToken());
		arriveY = Integer.parseInt(st.nextToken());
		
		queue.add(new info(startX,startY,0));
		map[startX][startY] =1;
		bfs();
		
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			if(temp.x==arriveX && temp.y==arriveY) {
				System.out.println(temp.move);
				return;
			}
			
			for(int i=0;i<6;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(range(nx,ny) && map[nx][ny]==0) {
					map[nx][ny] = 1;
					queue.add(new info(nx,ny,temp.move+1));
				}
				
			}
		}
		System.out.println(-1);
	}
	
	public static boolean range(int x,int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}

}
