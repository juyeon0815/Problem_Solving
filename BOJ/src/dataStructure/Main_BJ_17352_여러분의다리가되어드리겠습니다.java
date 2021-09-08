package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17352_여러분의다리가되어드리겠습니다 {
	
	static int N;
	static int [] parents;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		selected = new boolean[N+1];
		
		for(int i=1;i<N+1;i++) parents[i] = i;
		
		for(int i=0;i<N-2;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);

		}

		for(int i=1;i<parents.length;i++) selected[find(i)]= true; 
		
		for(int i=1;i<selected.length;i++) {
			if(selected[i]) sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
	
	public static void union(int x, int y) {
		int aRoot = find(x);
		int bRoot = find(y);
		
		if(aRoot<bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		
	}
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		return find(parents[x]);
	}

}
