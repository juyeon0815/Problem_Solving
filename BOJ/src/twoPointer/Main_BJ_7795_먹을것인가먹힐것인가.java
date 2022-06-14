package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_7795_먹을것인가먹힐것인가 {
	
	static int N,M;
	static int [] A,B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
			
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) B[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int count=0, key=0;
			for(int i=0;i<N;i++) {
				while(key!=M && A[i]>B[key]) key++;
				count+=key;
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());

	}

}
