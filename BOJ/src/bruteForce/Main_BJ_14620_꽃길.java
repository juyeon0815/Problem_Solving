package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_14620_꽃길 {
	
	static int N, answer= Integer.MAX_VALUE;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static int [][] map;
	static boolean [][] isSelected, visited;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isSelected = new boolean[N][N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		bruteForce(0);
		System.out.println(answer);
	}
	
	public static void bruteForce(int cnt) {
		if(cnt==3) {
			check();
			return;
		}
		
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<N-1;j++) {
				if(isSelected[i][j]) continue;
				list.add(new int[] {i,j});
				isSelected[i][j] = true;
				bruteForce(cnt+1);
				list.remove(list.size()-1);
				isSelected[i][j] = false;
			}
		}
	}
	
	public static void check() {
		visited = new boolean[N][N];
		
		int sum=0;
		for(int i=0;i<list.size();i++) {
			int [] item = list.get(i);
			visited[item[0]][item[1]] = true;
			sum+=map[item[0]][item[1]];
			for(int d=0;d<4;d++) {
				int nx = item[0] + dx[d];
				int ny = item[1] + dy[d];
				
				if(!range(nx,ny) || visited[nx][ny]) return;
				
				visited[nx][ny] = true;
				sum+=map[nx][ny];
				
			}
		}
		
		answer = Math.min(answer, sum);
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}
