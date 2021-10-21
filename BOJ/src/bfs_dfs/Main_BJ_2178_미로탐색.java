package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색 {
	
	static int N,M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String command = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = command.charAt(j)-48;
			}
		}
		
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	
	public static void bfs() {
		Queue<int []> queue = new LinkedList<>();
		
		queue.add(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && map[nx][ny]==1) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = map[temp[0]][temp[1]]+1;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
