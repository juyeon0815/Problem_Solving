package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11437_LCA {
	
	static int N,M,answer;
	static boolean [] visited;
	static int [] depth, parents;
	
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		depth = new int[N+1];
		parents = new int[N+1];
		
		for(int i=1;i<=N+1;i++) list.add(new ArrayList<>());
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			list.get(second).add(first);
			list.get(first).add(second);
		
		}
		
		depth[1] = 1;
		parents[1] = 0;
		findRelationShip(2,1);
		
//		for(int i=1;i<parents.length;i++) System.out.println(i+" , "+parents[i]);

		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int aRoot = Integer.parseInt(st.nextToken());
			int bRoot = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
			visited[0] = true;
			findParents(aRoot);
			findParents(bRoot);
			sb.append(answer+"\n");
		}
//		
		System.out.println(sb.toString());

	}
	//부모 자식 관계를 어떻게 찾아 낼 것인가..
	public static void findRelationShip(int cnt, int node) {
		
		for(int item : list.get(node)) {
			if(depth[item]==0) {
				depth[item] = cnt;
				parents[item] = node;
				findRelationShip(cnt+1, item);
			}
		}
		
	}
	
	
	public static void findParents(int node) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int item = queue.poll();
			if(visited[item]) {
				answer = item;
				return;
			}
			
			visited[item] = true;
			queue.add(parents[item]);
		}
	}
}
