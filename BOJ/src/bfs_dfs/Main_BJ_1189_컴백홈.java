package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1189_컴백홈 {
	
	static char [][] arr;
	static boolean [][] visited;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static int R,C,K, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<C;j++) arr[i][j] = line.charAt(j);
		}
		
		visited[R-1][0] = true;
		dfs(R-1,0,1);
		System.out.println(answer);

	}
	
	public static void dfs(int x, int y , int cnt) {
		if(x==0 && y==C-1) {
			if(cnt==K) answer++;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			
			if(!isRange(nx,ny) || arr[nx][ny]=='T' || visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx,ny,cnt+1);
			visited[nx][ny] = false;
		}
		
	}
	
	public static boolean isRange(int x, int y) {
		return x>=0 && x<R && y>=0 && y<C;
	}

}
