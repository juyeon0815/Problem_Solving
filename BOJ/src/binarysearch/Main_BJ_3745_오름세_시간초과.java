package binarysearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_3745_오름세_시간초과 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		int [] arr, dp;
		
		while(scan.hasNext()) {
			
			int n = scan.nextInt();
			arr = new int[n];
			dp = new int[n];
			
			for(int i=0;i<n;i++) arr[i] = scan.nextInt();
			
			for(int i=0;i<n;i++) {
				dp[i]=1;
				for(int j=0;j<i;j++) {
					if(arr[i]>arr[j] && dp[i]<dp[j]+1) dp[i]=dp[j]+1;
				}
			}
			
			Arrays.sort(dp);
			System.out.println(dp[n-1]);
		}
	}
}
