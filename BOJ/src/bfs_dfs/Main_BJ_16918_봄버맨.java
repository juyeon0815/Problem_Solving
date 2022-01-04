package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16918_봄버맨 {
	
	static int R,C,N;
	static char [][] map;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static Queue<int []> bomb = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char [R][C];
		
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='O') bomb.add(new int[] {i,j});
			}
		}
		
		simulation();
		print();
	}
	
	public static void simulation() {
		int time=1;
		while(time<N) {
			time++;
			bombInstall();
			if(time==N) break;
			time++;
			bombBlast();
			bombCheck();
		}
		
	}
	
	public static void bombInstall() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j] = 'O';
			}
		}
	}
	
	public static void bombCheck() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='O') bomb.add(new int[] {i,j});
			}
		}
	}
	
	public static void bombBlast() {
		while(!bomb.isEmpty()) {
			int [] temp = bomb.poll();
			
			map[temp[0]][temp[1]]='.';
			
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && map[nx][ny]=='O') {
					map[nx][ny] ='.';
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<R && y>=0 && y<C;
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
