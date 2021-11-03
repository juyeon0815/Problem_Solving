package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1717_집합의표현 {
	
	static int N,M;
	static int [] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		
		for(int i=1;i<parents.length;i++) parents[i] = i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command==0) { //합해라
				union(a,b);
			}else { // 확인
				if(find(a)==find(b)) sb.append("YES"+"\n");
				else sb.append("NO"+"\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void union(int a ,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot > bRoot) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
	}
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
	}

}
