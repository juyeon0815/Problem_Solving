package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1389_케빈베이컨의6단계법칙 {
	
	static int N,M;
	static int [][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		distance = new int[N][N];
		
		reset();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			distance [x-1][y-1] = distance[y-1][x-1] = 1;

		}
		
		floyd();
		cal();
		
	}
	
	public static void reset() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) distance[i][j] = 9999;
			}
		}
	}
	
	
	public static void floyd() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if(i==k) continue;
				for(int j=0;j<N;j++) {
					if(distance[i][k] + distance[k][j] < distance[i][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
	}
	
	public static void cal() {
		int min=Integer.MAX_VALUE, index=0, sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum+=distance[i][j];
			}
			if(sum<min) {
				min = sum;
				index = i;
			}
			sum=0;
		}
		System.out.println(index+1);
	}
}


