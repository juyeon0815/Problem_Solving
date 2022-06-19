package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14496_그대그머가되어 {
	
	static int N,M,start,end;
	static List<Integer> list[];
	static int [] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		count = new int[N+1];
		
		for(int i=1;i<count.length;i++) count[i] = Integer.MAX_VALUE;
		
		for(int i=1;i<list.length;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		bfs(start,end);
		System.out.println(count[end]==Integer.MAX_VALUE ? -1 :count[end]);
		
		
	}
	
	public static void bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		count[start] = 0;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();

			
			for(int item : list[temp]) {

				if(count[item]<=count[temp]+1) continue;
				count[item] = count[temp]+1;
				queue.add(item);
			}
		}
	}

}
