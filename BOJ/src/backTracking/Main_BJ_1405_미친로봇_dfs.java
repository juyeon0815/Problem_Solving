package backTracking;


import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_BJ_1405_미친로봇2 {
	
	static int N;
	static double [] probabiliy;
	static boolean [][] visited;
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	
	static double answer=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		probabiliy = new double[4];
		visited = new boolean[30][30];

		for(int i=0;i<4;i++) {
			probabiliy[i] = Double.parseDouble(st.nextToken())*0.01;
		}
		
		visited[15][15] = true;
		dfs(0,15,15,1);
		System.out.println(answer);

	}
	
	public static void dfs(int cnt, int x, int y, double prob) {
		if(cnt == N) {
			answer +=prob;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(range(nx,ny) && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(cnt+1,nx,ny,probabiliy[i]*prob);
				visited[nx][ny] = false;
			}
			
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<30 && y>=0 && y<30;
	}

}
