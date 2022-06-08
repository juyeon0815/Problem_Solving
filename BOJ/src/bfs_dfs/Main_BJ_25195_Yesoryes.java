package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_25195_Yesoryes {
	
	static int N,M, cnt;
	static List<Integer> list[];
	static boolean[] gomgom;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //정점 수
		M = Integer.parseInt(st.nextToken()); //간선 수
		
		list = new ArrayList[N+1];
		gomgom = new boolean[N+1];
		
		for(int i=0;i<N+1;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[start].add(end);
		}
		
		int num = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			gomgom[Integer.parseInt(st.nextToken())] = true;
		}
		
		if(!gomgom[1]) dfs(1);
		System.out.println(cnt>0? "yes" : "Yes");
	}
	
	public static void dfs(int index) {
		if(list[index].size()==0) {
			cnt++;
			return;
		}
		
		for(int item : list[index]) {
			if(!gomgom[item]) dfs(item);
		}
	}

}
