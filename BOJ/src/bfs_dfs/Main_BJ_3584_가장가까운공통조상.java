package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3584_가장가까운공통조상 {
	
	static int N, answer;
	static List<Integer> list[];
	static boolean [] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			list = new ArrayList[N+1];
			parents = new boolean[N+1];
			
			for(int i=1;i<list.length;i++) list[i] = new ArrayList<>();
			
			for(int i=0;i<N-1;i++) {
				st = new StringTokenizer(br.readLine());
				
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				list[child].add(parent);
			}
			
			st = new StringTokenizer(br.readLine());
			
			int findA = Integer.parseInt(st.nextToken());
			int findB = Integer.parseInt(st.nextToken());
			
			answer =0;
			dfs(findA);
			dfs(findB);
			
			System.out.println(answer);
			
		}

	}
	
	public static void dfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		
		if(!parents[node]) {
			parents[node] = true;
		}else {
			answer = node;
			return;
		}
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();

			for(int item : list[temp]) {
				if(parents[item]) {
					answer = item;
					return;
				}else {
					parents[item] = true;
					queue.add(item);
				}
			}
		}
	}
}
