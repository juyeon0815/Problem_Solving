package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14499_주사위굴리기 {
	
	static int []dx = {0,0,0,-1,1}; // 동 서 북 남
	static int []dy = {0,1,-1,0,0};
	
	static int N,M,x,y,K;
	static int [][] map;
	static int [] dice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		x = Integer.parseInt(st.nextToken()); //X좌표
		y = Integer.parseInt(st.nextToken()); //Y좌표
		K = Integer.parseInt(st.nextToken()); //명령 수
		
		map = new int[N][M];
		dice = new int[7];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int command = Integer.parseInt(st.nextToken());
			int nx = x+dx[command];
			int ny = y+dy[command];
			
			if(range(nx,ny)) { //map 범위안
				dice(command); //주사위 변경
				
				if(map[nx][ny]==0) {
					map[nx][ny] = dice[6];
				}else {
					dice[6] = map[nx][ny];
					map[nx][ny] = 0;
				}
				sb.append(dice[1]+"\n");
				x= nx;
				y= ny;
			}
		}
		System.out.println(sb.toString());

	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	
	public static void dice(int command) {
		int [] temp = dice.clone();
		
		if(command==1) { //동
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		}else if(command==2) { //서
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		}else if(command==3) { //북
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		}else if(command==4) { //남
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}
	}

}
