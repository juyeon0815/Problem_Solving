package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14503_로봇청소기 {
	
	
	static int N,M, robotX, robotY, dir, answer;
	static int [][] map;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		
		robotX = Integer.parseInt(st.nextToken());
		robotY = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(robotX, robotY, dir);
		
		System.out.println(answer);
	}
	
	public static void clean(int x, int y, int dir) {
		
		//현재 위치 청소
		if(map[x][y]==0) {
			map[x][y]=2;
			answer++;
		}
		
		boolean flag = false;
		int d = dir;
		
		for(int i=0;i<4;i++) {
			//왼쪽으로 회전 = 북 서 남 동
			int nd = (dir+3)%4;
			int nx = x + dx[nd];
			int ny = y + dy[nd];
			
			//왼쪽 방향에 청소하지 않은 공간 존재 => 왼쪽으로 회전 후 한칸 전진, 1번진행
			if(range(nx,ny) && map[nx][ny]==0) {
				clean(nx,ny,nd);
				flag = true;
				break;
			}
			//왼쪽 방향에 청소할 공간 x => 왼쪽으로 회전 2번 진행
			dir = nd;
		}
		
		if(!flag) {
			int nd = (d+2)%4;
			int nx = x + dx[nd];
			int ny = y + dy[nd];
			
			//네 방향 모두 청소 or 벽 => 바라보는 방향 유지 후진 2번 진행
			if(range(nx,ny) && map[nx][ny]!=1) {
				clean(nx,ny,d);
			}
		}
	}
	
	public static boolean range(int x , int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

}
