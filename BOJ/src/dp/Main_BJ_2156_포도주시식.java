package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_BJ_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] wine = new int[n+1];
		int [] dp = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = wine[1];
		
		if(n>1) dp[2] = dp[1]+wine[2];

		for(int i=3;i<n+1;i++) {
			int one = dp[i-2]+wine[i];
			int two = dp[i-3]+wine[i-1]+wine[i];
			
			dp[i] = Math.max(dp[i-1],Math.max(one, two) );
		}
		System.out.println(dp[n]);
	}
}
