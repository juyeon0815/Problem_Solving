package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1113_수영장만들기 {
	
	static int N,M, maxHigh=0,answer;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};

	static int [][] pool;
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pool = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				pool[i][j] = line.charAt(j)-48;
				maxHigh = Math.max(maxHigh, pool[i][j]);
			}
		}
		
		for(int h=1;h<=maxHigh;h++) {
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					if(pool[i][j]<h) answer+=bfs(h,i,j);
				}
			}
			
		}
		System.out.println(answer);
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(pool[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int bfs(int h, int x, int y) {
		queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		pool[x][y]++;
		int count=1;
		boolean flag = true;
		while(!queue.isEmpty()) {
			int [] item = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = item[0] + dx[i];
				int ny = item[1] + dy[i];
				
				if(!range(nx,ny)) {
					flag = false;
					continue;
				}
				
				if(pool[nx][ny]<h) {
					pool[nx][ny]++;
					count++;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		
		if(flag) return count;
		return 0;
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
