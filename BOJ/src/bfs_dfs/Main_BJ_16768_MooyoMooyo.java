package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16768_MooyoMooyo {
	
	static int N,M=10,K;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static Queue<int []> queue;
	static ArrayList<int []> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=  new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) map[i][j] = line.charAt(j)-48;
		}
		

		while(true) {
			//찾아서 없애기
			if(remove()==0) break;
			//내리기
			down();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(map[i][j]);	
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	
	
	public static int remove() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0) {
					visited = new boolean[N][M];
					cnt+=bfs(i,j, map[i][j]);
				}
			}
		}
		return cnt;
	}
	
	public static void down() {
		int x;
		for(int i=N-2;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0) {
					x=i;
					while(x<N-1 && map[x+1][j]==0) x++;
					if(x!=i) {
						map[x][j] = map[i][j];
						map[i][j] = 0;
					}
				}			
			}
		}
	}
	
	public static int bfs(int x ,int y, int num) {
		queue = new LinkedList<>();
		list = new ArrayList<>();
		
		queue.add(new int[] {x,y});
		list.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int [] item = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = item[0] + dx[i];
				int ny = item[1] + dy[i];
				
				if(!range(nx,ny) || visited[nx][ny] || map[nx][ny]!=num) continue;
				
				queue.add(new int[] {nx,ny});
				list.add(new int[] {nx,ny});
				visited[nx][ny] = true;
			}
		}
		
		if(list.size()>=K) {
			for(int i=0;i<list.size();i++) {			
				map[list.get(i)[0]][list.get(i)[1]] = 0;
			}
			return list.size();
		}
		
		return 0;
	}
	
	public static boolean range(int x ,int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
