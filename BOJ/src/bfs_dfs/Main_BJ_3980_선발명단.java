package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3980_선발명단 {
	
	static int [][] map;
	static int N=11, max;
	static boolean [] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			
			map = new int[N][N];
			selected = new boolean[N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			comb(0,0);
			System.out.println(max);
		}
	}
	
	public static void comb(int cnt,int sum) {
		if(cnt==N) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(map[cnt][i]==0 || selected[i]) continue;
			selected[i] = true;
			comb(cnt+1, sum+map[cnt][i]);
			selected[i] = false;
		}
	}
}
