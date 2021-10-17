package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14594_동방프로젝트 {
	
	static int [] room;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		room = new int[N+1];
		
		for(int i=1;i<=N;i++) room[i] = i;
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			union(start,end);
		}
		
		int cnt=0;
		for(int i=1;i<room.length;i++) {
			if(room[i]==i) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static void union(int x, int y) {
		int aRoot = find(x);
		int bRoot = find(y);
		
		if(aRoot<bRoot) {
			for(int i=x+1; i<=y;i++) room[i] = aRoot;
		}else {
			for(int i=x;i<y;i++) room[i] = bRoot;
		}
	}
	
	public static int find(int x) {
		if(room[x]==x) return x;
		return room[x]=find(room[x]);
	}

}
