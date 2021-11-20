package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14889_스타트와링크 {
	
	static int N, answer=Integer.MAX_VALUE;
	static int [][] map;
	static boolean [] visited;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		
		System.out.println(answer);
		
	}
	
	public static void comb(int start,int cnt) {
		if(cnt==N/2) {
			compare();
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			comb(i+1,cnt+1);
			visited[i] = false;
			
		}
	}
	
	public static void compare() {
		
		int start=0, link=0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(visited[i] && visited[j]) start+=map[i][j] + map[j][i];
				else if(!visited[i] && !visited[j]) link+=map[i][j] + map[j][i];
			}
		}
		
		answer = Math.min(answer, Math.abs(start-link));
		
	}

}
