package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_13565_침투 {
	
	static int N,M;
	static int [][] map;
	static Queue<int []> queue = new LinkedList<int[]>();
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-48;
				if(i==0 && map[i][j]==0) {
					queue.add(new int[] {i,j});
				}
			}
		}
		
		bfs();
		
		boolean flag = false;
		for(int i=0;i<M;i++) {
			if(map[N-1][i]==2) {
				flag = true;
				break;
			}
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				
				if(range(nx,ny)) {
					if(map[nx][ny]==0) {
						map[nx][ny]=2;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
	}
	
	public static boolean range(int x ,int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
