package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_13913_숨바꼭질4 {
	
	static int N,K, current;
	static int [] map, time;
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[100001];
		time = new int[100001];
		
		time[N] = 0;
		queue.add(N);
		
		bfs();

	}
	
	public static void bfs() {
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			if(temp==K) {
				int current = temp;
				while(current!=N) {
					list.add(current);
					current = map[current];
				}
				list.add(N);
				sb.append(list.size()-1+"\n");
				
				for(int i=list.size()-1;i>=0; i--) {
					sb.append(list.get(i)+" ");
				}
				System.out.println(sb.toString());
				return;
			}
			
			for(int i=0;i<3;i++) {
				int nx = 0;
				
				if(i==0) nx = temp-1;
				else if(i==1) nx = temp+1;
				else nx = temp*2;
				
				if(nx<0 || nx>100000) continue;
				
				if(time[nx]==0) {
					queue.add(nx);
					time[nx] = time[temp]+1;
					map[nx] = temp;
				}
			}
		}
	}

}
