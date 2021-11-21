package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_6603_로또 {
	
	static int k;
	static StringBuilder sb = new StringBuilder();
	static int [] number;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			
			if(k==0) break;
			
			number = new int[k];
			selected = new boolean[k];
			
			for(int i=0;i<k;i++) number[i] = Integer.parseInt(st.nextToken());
			comb(0,0);
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	
	public static void comb(int cnt, int start) {
		if(cnt==6) {
			for(int i=0;i<k;i++) {
				if(selected[i]) sb.append(number[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<k;i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			comb(cnt+1, i+1);
			selected[i] = false;
		}
	}

}
