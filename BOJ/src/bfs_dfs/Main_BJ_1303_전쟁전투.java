package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1303_전쟁전투 {
	
	static int N,M, powerB, powerW;
	static char [][] battleField;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		battleField = new char[M][N];
		
		for(int i=0;i<M;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				battleField[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(battleField[i][j]=='W' || battleField[i][j]=='B') bfs(i,j, battleField[i][j]);
			}
		}
		System.out.println(powerW+" "+powerB);
	}
	
	public static void bfs(int x, int y, char soldier) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		battleField[x][y] = 'A';
		
		int count=1;
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && battleField[nx][ny]==soldier) {
					battleField[nx][ny] = 'A';
					count++;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		
		if(soldier=='W') powerW+=count*count;
		else powerB+=count*count;
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}

}
