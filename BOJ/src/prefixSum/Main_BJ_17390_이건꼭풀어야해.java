package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_17390_이건꼭풀어야해 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N+1];
		int [] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
			
		for(int i=1;i<=N;i++) {
			sum[i]= sum[i-1]+arr[i];
		}
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			sb.append(sum[R]-sum[L-1]+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
