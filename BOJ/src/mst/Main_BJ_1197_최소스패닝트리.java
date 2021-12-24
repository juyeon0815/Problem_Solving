package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1197_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
	}
	
	static int V,E;
	static int [] parents;
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); //정점의 수
		E = Integer.parseInt(st.nextToken()); //간선의 수
		
		parents = new int[V+1];
		edgeList = new Edge[E]; 
		
		for(int i=0;i<parents.length;i++) parents[i] = i;
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(A,B,C);
		}
		
		Arrays.sort(edgeList);
		
		int result =0, count=0;
		for(Edge item : edgeList) {
			if(union(item.start,item.end)) {
				result+=item.weight;
				count++;
				if(count==V-1) break;
			}
		}
		System.out.println(result);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot!=bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
	}

}
