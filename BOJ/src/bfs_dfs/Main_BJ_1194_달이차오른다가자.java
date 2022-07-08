package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1194_달이차오른다가자 {
	
	static class Info{
		int x,y,cnt,key;

		public Info(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
	}
	
	static int N,M, answer=-1;
	static char [][] map;
	static boolean [][][] visited;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static Queue<Info> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='0') {
					queue.add(new Info(i,j,0,0));
					visited[i][j][0] = true;
				}
			}
		}
		
		bfs();
		System.out.println(answer);

	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Info item = queue.poll();
			
			if(map[item.x][item.y]=='1') {
				answer = item.cnt;
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nx = item.x + dx[i];
				int ny = item.y + dy[i];
				
				if(!range(nx,ny) || map[nx][ny]=='#' || visited[nx][ny][item.key]) continue;
				
				if('a'<=map[nx][ny]&&map[nx][ny]<='f') {
					int k = 1<<map[nx][ny]-'a' | item.key;

					visited[nx][ny][item.key] = true;
					visited[nx][ny][k]= true;
					queue.add(new Info(nx,ny,item.cnt+1, k));
				}else if('A'<=map[nx][ny]&&map[nx][ny]<='F') {
					
					if((item.key & (1 << map[nx][ny] - 'A')) > 0) {
						visited[nx][ny][item.key]= true;
						queue.add(new Info(nx,ny, item.cnt+1,item.key));
					}
				}else {
					queue.add(new Info(nx,ny,item.cnt+1, item.key));
					visited[nx][ny][item.key] = true;
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
