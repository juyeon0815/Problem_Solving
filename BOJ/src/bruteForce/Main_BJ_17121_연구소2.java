package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17121_연구소2 {
	
	static class info{
		int x, y;

		public info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N,M, time = Integer.MAX_VALUE;
	static int [][] map, copy;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};

	static ArrayList<info> list = new ArrayList<>();
	static ArrayList<info> select = new ArrayList<>();
	static Queue<info> queue = new LinkedList<>();
	static boolean [][] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //연구소 크기
		M = Integer.parseInt(st.nextToken()); //바이러스 개수
		
		map = new int[N][N];
		selected = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) map[i][j]= -1;
				else if(map[i][j]==2) {
					list.add(new info(i,j));
					map[i][j] =0;
				}
			}
		}
		comb(0,0);
		if(time==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(time);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==M) {
			// 바이러스 퍼지기 & 최소 시간 확인
			spread();
			return;
		}
		
		for(int i=start;i<list.size();i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			if(selected[x][y]) continue;
			
			select.add(new info(x,y));
			selected[x][y] = true;
			
			comb(cnt+1,i+1);
			selected[x][y] = false;
			select.remove(select.size()-1);
		}
		
	}
	
	public static void spread() {
		
		transfer();
		copy();
	
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(range(nx,ny) && copy[nx][ny]==0 && !selected[nx][ny]) {
					copy[nx][ny] = copy[temp.x][temp.y]+1;
					queue.add(new info(nx,ny));
				}
			}
		}
		if(time()!=-1 && time>time()) time=time();
	}
	
	public static void copy() {
		copy = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				copy[i][j]=map[i][j];
			}
		}
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
	
	public static void transfer() {
		for(int i=0;i<select.size();i++) {
			queue.add(new info(select.get(i).x, select.get(i).y));
		}
	}
	
	public static int time() {
		int min=0, count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j]>min) min = copy[i][j];
				if(copy[i][j]==0) count++;
			}
		}
		if(count!=M) return -1;
		
		return min;	
	}

}
