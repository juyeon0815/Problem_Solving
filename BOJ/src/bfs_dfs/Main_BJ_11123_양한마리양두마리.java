package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11123_양한마리양두마리 {
	
	static char [][] map;
	static int H,W;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static Queue<int []> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char [H][W];
			
			for(int i=0;i<H;i++) {
				String command = br.readLine();
				for(int j=0;j<W;j++) {
					map[i][j] = command.charAt(j);
				}
			}
			
			int count=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]=='#') {
						bfs(i,j);
						count++;
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());

	}
	
	public static void bfs(int x, int y) {
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0]+ dx[i];
				int ny = temp[1]+ dy[i];
				
				if(range(nx,ny) && map[nx][ny]=='#') {
					queue.add(new int[] {nx,ny});
					map[nx][ny]='.';
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<H && y>=0 && y<W; 
	}

}
