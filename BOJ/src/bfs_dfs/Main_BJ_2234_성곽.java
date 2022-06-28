package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2234_성곽 {
	
	static int N,M, answerF, answerS, answerT;
	static int [][] map, countMap;
	static boolean [][] visited;
	
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};
	
	static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		countMap = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					++answerF;
					bfs(i,j, answerF);
					
				}
			}
		}
		
		maxRoom();
		
		System.out.println(answerF);
		System.out.println(answerS);
		System.out.println(answerT);
	}
	
	public static void bfs(int x, int y, int num) {
		Queue<int[]> queue = new LinkedList<>();
		
		countMap[x][y] = num;
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int [] item = queue.poll();
			
			String dir = Integer.toBinaryString(map[item[0]][item[1]]);
			
			String zero = "";
			for(int i=0;i<4-dir.length();i++) zero = zero.concat("0");
			dir = zero.concat(dir);

			for(int i=0;i<4;i++) {
				char direction = dir.charAt(i);

				if(direction=='1') continue;
				
				int nx = item[0] + dx[i];
				int ny = item[1] + dy[i];
				if(range(nx,ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
					countMap[nx][ny] = num; 
					cnt++;
				}
 			}
			
		}
		
		answerS = Math.max(answerS, cnt);
		hm.put(num, cnt);
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}
	
	public static void maxRoom() {
		for(int i=0;i<M;i++) {
			for(int j=0; j<N;j++) {
				
				for(int d=0;d<4;d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(range(nx,ny)) {
						if(countMap[i][j]!=countMap[nx][ny]) answerT = Math.max(answerT, hm.get(countMap[i][j])+hm.get(countMap[nx][ny]));				
					}
				}
				
			}
			
		}
	}

}
