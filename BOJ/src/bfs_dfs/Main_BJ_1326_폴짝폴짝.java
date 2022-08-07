package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1326_폴짝폴짝 {
	
	static int N, start, end;
	static int [] bridge;
	static boolean [] visited;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		bridge = new int[N+1];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) bridge[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int res = bfs();
		System.out.println(res);

	}
	
	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start, 0});
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			if(temp[0]==end) {
				return temp[1];
			}
			
			int now= 1;
			while(true) {
				int nx = now*bridge[temp[0]];
				
				if(nx+temp[0]>N) break;
				
				if(!visited[nx+temp[0]]) {
					visited[nx+temp[0]] = true;
					queue.add(new int[] {nx+temp[0],temp[1]+1});
				}
				now++;
			}
			
			now=1;
			while(true) {
				int nx = now*bridge[temp[0]];
				
				if(temp[0]-nx<=0) break;
				
				if(!visited[temp[0]-nx]) {
					visited[temp[0]-nx] = true;
					queue.add(new int[] {temp[0]-nx,temp[1]+1});
				}
				now++;
			}	
		}
		return -1;
	}

}
