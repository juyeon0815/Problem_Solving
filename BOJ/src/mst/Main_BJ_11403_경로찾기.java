package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11403_경로찾기 {
	
	static int N;
	static int [][] distance;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		distance = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(distance[i][k]==1 && distance[k][j]==1) // 경유지를 통해 갈 수 있다면 해당 구간은 연결
						distance[i][j] = 1;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(distance[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		

	}

}
