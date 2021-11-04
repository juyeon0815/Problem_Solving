package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1976_여행가자 {
	
	static int [] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		
		for(int i=1;i<parents.length;i++) parents[i] = i;
		
		for(int i=1;i<parents.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<parents.length;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) union(i,j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = find(Integer.parseInt(st.nextToken()));
		
		boolean flag = true;
		for(int i=0;i<M-1;i++) {
			if(start!=find(Integer.parseInt(st.nextToken()))) {
				flag = false;
				break;
			}
		}
		
		if(!flag) System.out.println("NO");
		else System.out.println("YES");

	}
	
	public static void union(int a ,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot > bRoot) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
	}
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		else return parents[x] = find(parents[x]);
	}

}
