package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_11559_PuyoPuyo_211214 {
	
	
	static int R=12, C=6;
	static char [][] map;
	static boolean [][] visited;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static ArrayList<int []> item = new ArrayList<>();
	static Queue<int []> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String command = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = command.charAt(j);
			}
		}
		
		int count=0;
		while(true) {
			if(!check()) break;
			count++;
			down();
		}
		System.out.println(count);
		
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
	
	public static boolean check() {
		boolean result = false;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!='.') {
					if(bfs(i,j, map[i][j])) result = true;
				}
			}
		}
		return result;
	}
	
	public static boolean bfs(int x, int y, char color) {
		item.clear();
		visited = new boolean[R][C];
		
		visited[x][y] = true;
		item.add(new int[] {x,y});
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int [] temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && !visited[nx][ny] && color==map[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
					item.add(new int[] {nx,ny});
				}
			}
 		}
		
		if(item.size()>3) {
			for(int i=0;i<item.size();i++) {
				map[item.get(i)[0]][item.get(i)[1]]= '.';
			}
			return true;
		}
		return false;
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<R && y>=0 && y<C;
	}

}
