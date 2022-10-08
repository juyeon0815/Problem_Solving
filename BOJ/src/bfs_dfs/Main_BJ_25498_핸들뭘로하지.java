package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_25498_핸들뭘로하지 {
	
	static int N;
	static char [] alpabet;
	static ArrayList<Integer> node[];
	static ArrayList<Character> result;
	static boolean [] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		
		alpabet = line.toCharArray();
		
		node = new ArrayList[N+1];
		
		visited = new boolean[N+1];
		
		
		for(int i=0;i<N+1;i++) node[i] = new ArrayList<>();
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			node[start].add(end);
			node[end].add(start);
		}
		
		bfs(1);
	}
	
	public static void bfs(int start) {
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		result = new ArrayList<>();
		
		sb.append(alpabet[start-1]);
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {

			char compare='a';
			list.clear();
			for(int temp : queue) {
				for (int item  : node[temp]) {
					if(!visited[item]) {
						
						if(compare<alpabet[item-1]) {
							list.clear();
							list.add(item);
							compare = alpabet[item-1];
							
						}else if(compare==alpabet[item-1]) {
							list.add(item);
						}
					}
				}
			}
			queue.clear();
			
			if(list.size()==0) break;

			sb.append(compare);
			for(int i=0;i<list.size();i++) {
				visited[list.get(i)] = true;
				queue.add(list.get(i));
			}
		}
		
		System.out.println(sb.toString());
	}
}