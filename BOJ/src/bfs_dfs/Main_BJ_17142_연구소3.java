package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17142_연구소3 {
	
	static class info {
		int x, y, cnt;

		public info(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int N,M, virusCnt, answer= Integer.MAX_VALUE;
	static int [][] map;
	static List<int[]> virus = new ArrayList<>();
	static List<int[]> virusSelect = new ArrayList<>();
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virus.add(new int[] {i,j});
				else if(map[i][j]==0) virusCnt++;
			}
		}
		
		if(virusCnt==0) {
			System.out.println(0); 
			return;
		}
		
		selectedVirus(0, 0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);

	}
	
	public static void selectedVirus(int cnt, int start) {
		if(cnt == M) {
			bfs();
			return;
		}
		
		for(int i=start; i<virus.size();i++) {
			virusSelect.add(virus.get(i));
			selectedVirus(cnt+1, i+1);
			virusSelect.remove(virusSelect.size()-1);
		}
	}
	
	public static void bfs() {
		Queue<info> queue = new LinkedList<>();
		boolean [][] visited = new boolean[N][N];

		for(int i=0;i<virusSelect.size();i++) {
			visited[virusSelect.get(i)[0]][virusSelect.get(i)[1]]=true;
			queue.add(new info(virusSelect.get(i)[0],virusSelect.get(i)[1],1));
		}
		
		int cnt=0, time=0;
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				time = temp.cnt;
				
				if(range(nx,ny) &&!visited[nx][ny]) {
					if(map[nx][ny]==0) {
						visited[nx][ny] = true;
						cnt++;
						queue.add(new info(nx,ny,temp.cnt+1));
					}else if(map[nx][ny]==2) {
						visited[nx][ny] = true;
						queue.add(new info(nx,ny,temp.cnt+1));
					}
				}
			}
			
			if(cnt == virusCnt) {
				time++;
				break;
			}
		}
		
		if(cnt ==virusCnt) answer = Math.min(answer, time-1);
	}
	
	public static boolean range(int x ,int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}
