package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2169_로봇조종하기 {
	
	static int N,M;
	static int [][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp();
		System.out.println(dp[N-1][M-1]);

	}
	
	public static void dp() {
		
		dp[0][0] = map[0][0];
		for(int i=1;i<M;i++) dp[0][i] = dp[0][i-1]+map[0][i]; //첫줄은 -> 가는게 최대
		
		for(int i=1;i<N;i++) {
			dp[i][0] = dp[i-1][0]+map[i][0];
			
			int [] left = new int[M];
			
			//위, 왼쪽에서의 최대
			left[0]= dp[i-1][0]+map[i][0];
			for(int j=1;j<M;j++) {
				int max = Math.max(dp[i-1][j], left[j-1]);
				left[j] = max+map[i][j];
			}
			
			int [] right = new int[M];
			
			//위,오른쪽에서의 최대
			right[M-1] = dp[i-1][M-1]+map[i][M-1];
			for(int j=M-2;j>=0;j--) {
				int max = Math.max(dp[i-1][j], right[j+1]);
				right[j] = max+map[i][j];
			}
			
			for(int j=0;j<M;j++) dp[i][j] = Math.max(left[j], right[j]);
			
		}
	}

}
