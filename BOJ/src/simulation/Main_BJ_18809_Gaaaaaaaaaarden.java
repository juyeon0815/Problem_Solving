package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_18809_Gaaaaaaaaaarden {
	
	static class info{
		int x, y;

		public info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M,G,R, max = 0;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static int [][] map;
	static int [] green, red;
	static boolean [] visited;
	
	static ArrayList<info> list = new ArrayList<>();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		green = new int[G];
		red = new int[R];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new info(i,j));
					map[i][j] = 1;
				}
			}
		}
		visited = new boolean[list.size()];
		
		gPerm(0,0);
		System.out.println(max);
	}
	
	public static void gPerm(int start, int cnt) {
		if(cnt == G) {
			//빨간색 뽑기
			rPerm(0,0);
			return;
		}
		
		for(int i=start; i<list.size();i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			green[cnt] = i;
			gPerm(i+1, cnt+1);
			visited[i] = false;
		}
	}
	
	public static void rPerm(int start, int cnt) {
		if(cnt == R) {
			//빨간색도 다 뽑았으면 이제 bfs돌리기
			bfs();
			return;
		}
		for(int i=start; i<list.size();i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			red[cnt] = i;
			rPerm(i+1, cnt+1);
			visited[i] = false;
		}
	}
	
	public static void bfs() {
		Queue<info> queue = new LinkedList<>();
		
		int [][] copy = new int [N][M];
		int [][] time = new int [N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		
		//초록색 먼저 배양 놓기
		for(int i=0;i<green.length;i++) {
			info temp = list.get(green[i]);
			copy[temp.x][temp.y] = 3;
			queue.offer(new info(temp.x,temp.y));
		}
		
		//빨간색 배양 놓기
		for(int i=0;i<red.length;i++) {
			info temp = list.get(red[i]);
			copy[temp.x][temp.y] = 4;
			queue.offer(new info(temp.x,temp.y));
		}
		
		//퍼지기
		int sum =0;
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			if(copy[temp.x][temp.y]==5) continue;
			
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(range(nx,ny) && copy[nx][ny]!=0) {
					
					if(copy[nx][ny]==1) {
						copy[nx][ny] = copy[temp.x][temp.y];
						time[nx][ny] = time[temp.x][temp.y]+1;
						queue.add(new info(nx,ny));
					}else if(copy[nx][ny]==3) { //초록색 배양이 있을 경우
						if(copy[temp.x][temp.y]==4 && time[nx][ny] == time[temp.x][temp.y]+1) { //빨간색 배양일 경우
							copy[nx][ny] = 5; // 꽃
							sum++;
						}
					}else if(copy[nx][ny]==4) { //빨간색 배양이 있을 경우
						if(copy[temp.x][temp.y]==3 && time[nx][ny] == time[temp.x][temp.y]+1) { //초록색 배양일 경우
							copy[nx][ny] = 5; // 꽃
							sum++;
						}
					}
				}
			}
		}

		max = Math.max(max, sum);
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
