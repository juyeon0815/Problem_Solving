package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_20058_마법사상어와파이어스톰 {
	
	static int N,Q, iceSum, iceSize;
	static int [][] map;
	static boolean [][] visited;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		N = (int) Math.pow(2, N);
		
		map = new int [N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			int L = Integer.parseInt(st.nextToken());
			
			//부분 격자로 나누기
			division(L);
			
			//얼음 양 줄이기
			melt();
		}
		
		cal();
		//남아있는 얼음 합
		System.out.println(iceSum);
		//가장 큰 덩어리가 차지하는 칸의 개수
		System.out.println(iceSize);

	}
	
	public static void division(int size) {
		int [][] rotate = new int[N][N];
		size = (int) Math.pow(2, size);
		for(int i=0;i<N;i=i+size) {
			for(int j=0;j<N;j=j+size) {
				
				for(int x=0;x<size;x++) {
					for(int y=0;y<size;y++) {
						rotate[x+i][y+j] = map[i+size-1-y][j+x]; 
					}
				}
				
			}
		}
		
		map = rotate;
	}
	
	public static void melt() {
		int [][] ice = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ice[i][j] = map[i][j];
			}
		}
		
		int count;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				count=0;
				if(map[i][j]==0) continue;
				
				for(int d=0;d<4;d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(!range(nx,ny) || map[nx][ny]<=0) continue;
						
					count++;
				}
				
				if(count<3) ice[i][j]--;
			}
		}
		
		map = ice;
		
	}

	public static void cal() {
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				iceSum+=map[i][j];
				if(map[i][j]>0 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		int count=1;
		while(!queue.isEmpty()) {
			int [] item = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = item[0] + dx[i];
				int ny = item[1] + dy[i];
				
				if(!range(nx,ny) || map[nx][ny]<=0 || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				queue.add(new int[] {nx,ny});
				count++;
			}
		}
		
		iceSize = Math.max(iceSize, count);
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}
