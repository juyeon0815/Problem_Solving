package bfs_dfs;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_BJ_16469_소년점프 {
	
	static class info{
		int x,y,time;
		boolean [][] visited;
		public info(int x, int y, int time, boolean[][] visited) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.visited = visited;
		}
	}
	
	static int [][] map, time;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static int R,C;
	static Queue<info> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		time = new int[R][C];
		
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = line.charAt(j)-48;
				if(map[i][j]==1) map[i][j] = -1;
			}
		}
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			queue.add(new info(x,y,0,new boolean[R][C]));
			map[x][y] = 1;
		}
		
		bfs();
		find();
	}
	
	public static void bfs() {
		int size = queue.size();
		for(int i=0;i<size;i++) {
			info temp = queue.poll();
			temp.visited[temp.x][temp.y] = true;
			
			queue.add(new info(temp.x,temp.y,temp.time,temp.visited));
		}
		
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(range(nx,ny) && map[nx][ny]!=-1 && !temp.visited[nx][ny]) {
					temp.visited[nx][ny] = true;
					map[nx][ny]++;
					queue.add(new info(nx,ny,temp.time+1,temp.visited));
					
					if(map[nx][ny]==3) time[nx][ny] = temp.time+1;
				}				
			}
		}
	}
	
	public static boolean range(int x ,int y) {
		return x>=0 && x<R && y>=0 && y<C;
	}

	public static void find() {
		int min = Integer.MAX_VALUE, count=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(time[i][j]!=0 && min>time[i][j]) {
					min = time[i][j];
					count=1;
				}
				
				else if(min==time[i][j]) count++;
			}
		}
		
		if(min==Integer.MAX_VALUE) System.out.println("-1");
		else {
			System.out.println(min+"\n"+count);
		}
	}

}
