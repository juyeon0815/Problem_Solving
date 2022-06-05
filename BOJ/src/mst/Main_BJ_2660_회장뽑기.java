package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_2660_회장뽑기 {
	
	static int N;
	static int [][] distance;
	static HashMap<Integer, List<Integer>> hm = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		distance = new int[N][N];
		
		reset();
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			if(start<-1 && end<-1) break;
			distance[start][end] = distance[end][start] = 1;
		}
		
		floyd();
		cal();

	}
	
	public static void cal() {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		int min = Integer.MAX_VALUE;
		
		int [] scoreArr = new int[N];
		
		for(int i=0;i<N;i++) {
			int score=0;
			for(int j=0;j<N;j++) {
				if(distance[i][j]!=999) score = Math.max(score, distance[i][j]);
			}
			scoreArr[i] = score;
			min = Math.min(min, score);
		}
		
		sb.append(min+" ");
		
		int count=0;
		for(int i=0;i<N;i++) {
			if(scoreArr[i]==min) {
				count++;
				sb2.append((i+1)+" ");
			}
		}
		sb.append(count);
		
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
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
	
	public static void reset() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				distance[i][j] = 999;
			}
		}
	}
}
