package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_2667_단지번호붙이기 {
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static int N, count=0;
	static int [][] map;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = line.charAt(j)-48;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					bfs(i,j);
					count++;
				}
			}
		}
		
		Collections.sort(list);
		sb.append(count+"\n");
		for(int i=0;i<list.size();i++) sb.append(list.get(i)+"\n");
		
		System.out.println(sb.toString());

	}
	
	public static void bfs(int x, int y) {
		Queue<int []> queue = new LinkedList<int[]>();
		queue.add(new int[] {x,y});
		
		int num=0;
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && map[nx][ny]==1) {
					map[nx][ny] = 0;
					queue.add(new int[] {nx,ny});
					num++;
				}
				
			}
		}
		if(num==0) list.add(1);
		else list.add(num);
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}

}
