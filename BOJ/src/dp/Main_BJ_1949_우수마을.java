package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_1949_우수마을 {
	
	static List<Integer> list[];
	static int[][] dp;
	static int[] person;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		person = new int[N+1];
		dp = new int[N+1][2];
		
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int town = Integer.parseInt(st.nextToken());
			int town2 = Integer.parseInt(st.nextToken());
			
			list[town].add(town2);
			list[town2].add(town);
		}
		
		dfs(1,0);
		System.out.println(Math.max(dp[1][0], dp[1][1]));

	}
	
	public static void dfs(int n, int parent) {
		for(int item : list[n]) {
			if(item!=parent) {
				dfs(item,n);
				dp[n][0]+=Math.max(dp[item][0],dp[item][1]);
				dp[n][1]+=dp[item][0];
			}
		}
		
		dp[n][1]+=person[n];
	}
}
