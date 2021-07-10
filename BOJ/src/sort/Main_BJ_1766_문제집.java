package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1766_문제집 {
	
	static int N,M;
	static int [] indegree;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //문제의 수
		M = Integer.parseInt(st.nextToken()); // 문제에 대한 정보 수
		
		indegree = new int[N+1];
		
		for(int i=0;i<=N;i++) list.add(new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int first = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			list.get(first).add(next);
			indegree[next]++;
		}
		
		sort();
		System.out.println(sb.toString());
	}
	
	public static void sort() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=1;i<N+1;i++) {
			if(indegree[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			sb.append(temp+" ");
			
			for(int item:list.get(temp)) {
				indegree[item]--;
				if(indegree[item]==0) queue.add(item);
			}
		}
	}
}
