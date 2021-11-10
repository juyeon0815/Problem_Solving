package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15649_N과M {
	
	static int N,M;
	static boolean [] select;
	static int [] number;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //1~N
		M = Integer.parseInt(st.nextToken()); //고른 개수
		
		select = new boolean[N];
		number = new int[M];
		comb(0);
		System.out.println(sb.toString());
		
	}
	
	public static void comb(int cnt) {
		if(cnt==M) {
			for(int i=0;i<number.length;i++) {
				sb.append(number[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N;i++) {
			if(select[i]) continue;
			number[cnt]=i+1;
			select[i] = true;
			comb(cnt+1);
			select[i] = false;
		}
	}

}
