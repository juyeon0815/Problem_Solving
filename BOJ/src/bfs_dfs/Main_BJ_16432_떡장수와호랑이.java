package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_16432_떡장수와호랑이 {
	
	static ArrayList<Integer> list[] ;
	static boolean[][] visited;
	static int [] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine()); // 떡장사 나가는날
		
		list = new ArrayList[N+1];
		
		for(int i=1;i<N+1;i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken()); //오늘의 떡 개수
			
			for(int j=0;j<M;j++) {
				int type = Integer.parseInt(st.nextToken()); // 떡 종류
				list[i].add(type);
			}
		}
		
		visited = new boolean[N+2][10];
		result = new int[N+1];
		dfs(1,N,0);
		System.out.println("-1");

	}
	
	public static void dfs(int cnt, int N, int prev) {	
		if(cnt==N+1) {
			for(int i=1;i<N+1;i++) {
				System.out.println(result[i]);
			}
			System.exit(0);
		}
		
		for(int i=1;i<10;i++) {
			if(i!=prev && !visited[cnt+1][i] && list[cnt].contains(i)) {
				visited[cnt+1][i] = true;
				result[cnt]=i;
				dfs(cnt+1,N,i);
			}
		}
	}
}
