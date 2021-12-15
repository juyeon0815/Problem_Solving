package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17142_연구소3 {
	
	static class info{
		int x, y , time;

		public info(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int N,M, answer = Integer.MAX_VALUE, blank;
	
	static int [][] map, copy;
	static int [][] direction = {{-1,0},{0,1}, {1,0}, {0,-1}};
	static ArrayList<int []> select = new ArrayList<>();
	static ArrayList<int []> birus = new ArrayList<>();
	static Queue<info> queue = new LinkedList<>();
	static boolean [][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					birus.add(new int[] {i,j});
				}
				else if(map[i][j]==0) blank++;
			}
		}
		
		if(blank==0) System.out.println(0);
		else {
			comb(0,0);
			System.out.println(answer==Integer.MAX_VALUE? -1: answer);
		}
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==M) {
			spread();
			return;
		}
		
		for(int i=start;i<birus.size();i++) {
			select.add(new int[] {birus.get(i)[0], birus.get(i)[1]});
			comb(cnt+1,i+1);
			select.remove(select.size()-1);
		}
	}
	
	public static void spread() {
		visited = new boolean[N][N];
		queue.clear();
		for(int i=0;i<select.size();i++) {
			queue.add(new info(select.get(i)[0], select.get(i)[1],0));
			visited[select.get(i)[0]][select.get(i)[1]] = true;
		}
		
		int count = blank;
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x+ direction[i][0];
				int ny = temp.y+ direction[i][1];
				
				if(range(nx,ny) && !visited[nx][ny] && map[nx][ny]!=1) {
					
					if(map[nx][ny]==0) {
						count--;
					}
					
					if(count==0) {
						answer = Math.min(answer, temp.time+1);
						return;
					}
					
					visited[nx][ny] = true;
					queue.add(new info(nx,ny, temp.time+1));
					
				}
			}
		}
	}
	
	public static boolean range(int x ,int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}
