package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14502_연구소_시간단축 {
	
	static int N,M, answer=0;;
	static int [][] map, copyMap;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static Queue<int [] > queue = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		settingWall(0);
		System.out.println(answer);
	}
	
	public static void settingWall(int cnt) {
		if(cnt==3) {
			spread();
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					settingWall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void spread() {
		copyMap();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==2) queue.add(new int[] {i,j});
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				
				if(range(nx,ny) && copyMap[nx][ny]==0) {
					copyMap[nx][ny]=2;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		
		check();
	}
	
	public static void copyMap() {
		copyMap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	
	public static void check() {
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==0) count++;
			}
		}
		answer = Math.max(answer, count);
	}

}
