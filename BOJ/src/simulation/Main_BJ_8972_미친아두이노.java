package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_8972_미친아두이노 {
	
	static class info{
		int x, y;

		public info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int R,C;
	static char [][] map;
	
	static Queue<info> jongsoo = new LinkedList<>();
	static Queue<info> crazy = new LinkedList<>();
	static Queue<info> delete = new LinkedList<>();
	
	static int [] dx = {0,1,1,1,0,0,0,-1,-1,-1};
	static int [] dy = {0,-1,0,1,-1,0,1,-1,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String command = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = command.charAt(j);
				if(map[i][j]=='I') jongsoo.add(new info(i,j));
				else if(map[i][j]=='R') crazy.add(new info(i,j));
			}
		}
		
		int count=1;
		
		boolean flag = true;
		String direction = br.readLine();
		for(int i=0;i<direction.length();i++) {
			if(!jongsoo_move(direction.charAt(i)-48)) {
				flag = false;
				break;
			}
			if(!crazy_move()) {
				flag = false;
				break;
			}
			map();
			count++;
		}
		if(!flag) System.out.println("kraj "+ count);
		else print();
	}
	
	
	public static boolean jongsoo_move(int dir) {
		info temp = jongsoo.poll();
		
		int nx = temp.x + dx[dir];
		int ny = temp.y + dy[dir];

		if(map[nx][ny]=='R') return false;
		else {
			jongsoo.add(new info(nx,ny));
			if(dir!=5) {
				map[nx][ny] = map[temp.x][temp.y];
				map[temp.x][temp.y] = '.';
			}
			return true;
		}
	}
	
	public static boolean crazy_move() {
		int[][] temp = new int[R][C];
		
		info js = jongsoo.peek();
		
		int jsX = js.x;
		int jsY = js.y;
		
		while(!crazy.isEmpty()) {
			
			info cr = crazy.poll(); 
			
			int len = Integer.MAX_VALUE;
			int dir = 0;
			for(int j=1;j<10;j++) {
				if(j==5) continue;
				int nx = cr.x+dx[j];
				int ny = cr.y+dy[j];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				
				int distance = Math.abs(jsX-nx) + Math.abs(jsY-ny);
				
				if(distance<len) {
					len = distance;
					dir = j;
				}
			}
			
			int moveX = cr.x+dx[dir];
			int moveY = cr.y+dy[dir];
			
			
			if(map[moveX][moveY]=='I') {
				return false;
			}
			
			temp[moveX][moveY] += 1;
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(temp[i][j] == 1) {
					crazy.add(new info(i, j));
				}
			}
		}
		
		return true;
	}
	
	public static void map() {
		for(int i=0;i<R;i++) Arrays.fill(map[i], '.');
		
		info js = jongsoo.peek();
		
		map[js.x][js.y] = 'I';
		
		for(int i=0;i<crazy.size();i++) {
			info cr = crazy.poll();
			map[cr.x][cr.y] = 'R';
			crazy.add(new info(cr.x, cr.y));
		}
	}
	
	public static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}


