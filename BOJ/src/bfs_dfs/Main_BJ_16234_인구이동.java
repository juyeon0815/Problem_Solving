package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16234_인구이동 {
	
	static int N, L, R, moveCnt, answer;
	static int [][] map, division;
	static boolean [][] isVisited;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static List<int []> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		list= new ArrayList[N*N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		play();
		System.out.println(answer);

	}
	
	public static void play() {
		
		while(true) {

			for(int i=1;i<list.length;i++) list[i] = new ArrayList<>();
			moveCnt=0;
			//국경선 열기
			int num = openBorder();
			//인구 이동
			
			if(moveCnt==0) break;
			populationMigration(num);
			answer++;
		}
		
	}
	
	public static int openBorder() {
		division = new int[N][N];
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(division[i][j]==0) bfs(i,j,++cnt);
			}
		}
		return cnt;
	}
	
	public static void bfs(int x, int y , int index) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		division[x][y] = index;
		list[index].add(new int[] {x,y});
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				                         
				if(range(nx,ny) && division[nx][ny]==0) {
					int populationDiff = Math.abs(map[temp[0]][temp[1]]- map[nx][ny]);
					if(L<=populationDiff && populationDiff<=R ) {
						division[nx][ny] = index;
						queue.add(new int[] {nx,ny});
						list[index].add(new int[] {nx,ny});
					}
					
				}
			}
		}
		if(list[index].size()>1) moveCnt++;
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
	
	public static void populationMigration(int index) {
		for(int i=1;i<=index;i++) {
			
			if(list[i].size()>1) {
				int sum=0;
				for(int [] item : list[i]) {
					sum+=map[item[0]][item[1]];
				}
				sum=sum/list[i].size();
				
				for(int [] item : list[i]) {
					map[item[0]][item[1]] = sum;
				}
			}
		}
	}
}
