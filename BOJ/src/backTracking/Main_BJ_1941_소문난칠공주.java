package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_1941_소문난칠공주 {
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int [][] map;
	static int [] member;
	static boolean [][] selected;
	static int N =5, answer;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[N][N];
		member = new int[7];
		selected = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		comb(0,0);
		System.out.println(answer);
		
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == 7) { //7명으로 구성, 이다솜파 >=4
			if(memberCount() && memberConnect()) answer++;
			return;
		}
		
		for(int i=start;i<25;i++) {
			member[cnt] = i;
			selected[i/5][i%5] = true;
			comb(cnt+1,i+1);
			selected[i/5][i%5] = false;
		}
	}
	
	public static boolean memberCount() {
		
		int count=0;
		for(int i=0;i<member.length;i++) {
			int index = member[i];
			
			if(map[index/5][index%5]=='S') count++;
		}
		
		if(count>=4) return true;
		else return false;
	}
	
	public static boolean memberConnect() {
		Queue<int []> queue = new LinkedList<int[]>();
		boolean [][] visited = new boolean[N][N];
		
		queue.add(new int[]{member[0]/5, member[0]%5});
		visited[member[0]/5][member[0]%5] = true;
		
		int count=1;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(range(nx,ny) && !visited[nx][ny] && selected[nx][ny]) {
					queue.add(new int[] {nx,ny});
					visited[nx][ny] = true;
					count++;
				}
			}
			
		}
		
		if(count==7) return true;
		else return false;
		
	}
	
	public static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}

}
