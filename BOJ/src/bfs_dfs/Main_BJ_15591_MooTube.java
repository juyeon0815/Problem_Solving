package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_15591_MooTube {
	
	static int N,Q,k,v;
	static ArrayList<int[]> list[];
	static Queue<Integer> queue;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			list[p].add(new int[] {q,r});
			list[q].add(new int[] {p,r});
		}
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
			bfs(k,v);
		}
		
		System.out.println(sb.toString());

	}
	
	public static void bfs(int k, int v) {
		visited[v] = true;
		
		queue = new LinkedList<>();
		queue.add(v);
		
		int cnt =0;
		while(!queue.isEmpty()) {
			int item = queue.poll();
			
			for(int [] temp : list[item]) {
				if(!visited[temp[0]] && temp[1]>=k) {
					queue.add(temp[0]);
					visited[temp[0]] = true;
					cnt++;
				}
			}
		}
		sb.append(cnt+"\n");
	}

}
