package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1525_퍼즐 {
	
	static class info{
		int x,y;
		int [][] map = new int[3][3];
		public info(int x, int y, int[][] map) {
			super();
			this.x = x;
			this.y = y;
			this.map = map;
		}
	}
	
	static int[][] puzzle, copy;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static Queue<info> queue = new LinkedList<>();
	static HashMap<String, Integer> map=new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static StringBuilder last = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		puzzle = new int[3][3];
		
		int startX=0, startY=0;
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
				if(puzzle[i][j]==0) {
					puzzle[i][j] = 9;
					startX = i; startY = j;
				}
			}
		}
		
		boolean check = true;
		int count=1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				sb.append(puzzle[i][j]);
				if(count++!=puzzle[i][j]) check= false;
			}
		}

		if(check) System.out.println(0);
		else {
			map.put(sb.toString(), 0);
			sb.setLength(0);
			queue.add(new info(startX, startY,puzzle));
			bfs();
		}
		
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			last.setLength(0);
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					last.append(temp.map[i][j]);
				}
			}
			
			for(int i=0;i<4;i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if(!range(nx,ny)) continue;
				else {
					
					copy(temp.map);
					
					int change = temp.map[nx][ny];
					
					copy[nx][ny] = temp.map[temp.x][temp.y];
					copy[temp.x][temp.y] = change;
					
					
					sb.setLength(0);
					for(int a=0;a<3;a++) {
						for(int b=0;b<3;b++) {
							sb.append(copy[a][b]);
						}
					}
					
					if(sb.toString().equals("123456789")) {
						System.out.println(map.get(last.toString())+1);
						return;
					}
					
					if(!map.containsKey(sb.toString())) {
						queue.add(new info(nx,ny,copy));
						map.put(sb.toString(),map.get(last.toString())+1);
					}
				}				
				
			}
		}
		System.out.println(-1);
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<3 && y>=0 && y<3;
	}
	
	public static void copy(int [][] map) {
		copy = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
}
