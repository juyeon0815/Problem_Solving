package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1051_숫자정사각형 {
	
	static int N,M;
	static int [][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j)-48;
			}
		}
		
		int size = Math.min(N, M);
		int answer =1;
		loop :
		for(int k=size;k>=1;k--) {
			for(int i=0;i<=N-k;i++) {
				for(int j=0;j<=M-k;j++) {
					if(map[i][j]==map[i][j+k-1] && map[i][j+k-1]==map[i+k-1][j+k-1] && map[i][j]==map[i+k-1][j] && map[i+k-1][j]==map[i+k-1][j+k-1]) {
						answer = k*k;
						break loop;
					}
				}
			}
		}
		System.out.println(answer);

	}
}
