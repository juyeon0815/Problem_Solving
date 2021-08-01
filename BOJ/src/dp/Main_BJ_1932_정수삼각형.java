package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] map = new int [N][N];
		

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//맨밑에서부터
		for(int i=N-1;i>=0; i--) {
			for(int j=0;j<i;j++) {
				map[i-1][j]+=Math.max(map[i][j], map[i][j+1]);
			}
		}
		
		System.out.println(map[0][0]);
	}

}
