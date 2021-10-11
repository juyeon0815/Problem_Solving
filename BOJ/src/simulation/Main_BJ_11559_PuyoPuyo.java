package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_11559_PuyoPuyo {
	
	static char [][] map;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static int answer=0;

	static Queue<int []> queue = new LinkedList<>();
	static ArrayList<int []> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		
		for(int i=0;i<12;i++) {
			String command = br.readLine();
			for(int j=0;j<6;j++) {
				map[i][j] =  command.charAt(j);
			}
		}
		
		simulation();
		System.out.println(answer);
	}
	
	public static void simulation() {
		while(true) {
			boolean flag = false;
			
			for(int i=11;i>=0;i--) {
				for(int j=0;j<6;j++) {
					if(map[i][j]!='.') {
						queue.clear();
						list.clear();
						queue.add(new int[] {i,j});
						list.add(new int[] {i,j});
						bfs(map[i][j]);
						
						if(list.size()>=4) {
							flag = true;
							brust();
						}
					}
				}
			}
			
			if(!flag) break;
			else {
				answer++;
				down();
			}
		}
	}
	
	public static void bfs(char color) {
		boolean [][] visited = new boolean[12][6];
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			visited[temp[0]][temp[1]] = true;
			
			for(int i=0;i<4;i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				
				if(range(nx,ny) && map[nx][ny]==color && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
					list.add(new int[] {nx,ny});
				}
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<12 && y>=0 && y<6;
	}
	
	public static void brust() {
		for(int i=0;i<list.size();i++) {
			map[list.get(i)[0]][list.get(i)[1]] = '.';
		}
	}
	
	public static void down() {
		for(int i=10; i>=0; i--) {
			for(int j=0;j<6;j++) {
				if(map[i][j]!='.') {
					int index = i;
					while(index<11 && map[index+1][j]=='.') {
						index++;
					}
					
					if(index!=i) {
						map[index][j] = map[i][j];
						map[i][j] = '.';
					}
				}
			}
		}
	}
}
