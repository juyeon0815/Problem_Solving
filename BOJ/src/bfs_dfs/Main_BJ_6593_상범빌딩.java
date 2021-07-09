package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_6593_상범빌딩 {
	
	static class info implements Comparable<info>{
		int z,x,y,cnt;

		public info(int z, int x, int y, int cnt) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(info o) {
			return this.cnt-o.cnt;
		}
		
	}
	
	static int L,R,C;
	static char [][][] map;
	static boolean [][][] visited;
 	
	static int [] dx= {-1,0,1,0,0,0};
	static int [] dy= {0,1,0,-1,0,0};
	static int [] dz= {0,0,0,0,1,-1};
	
	static PriorityQueue<info> pq = new PriorityQueue<>();

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L==0 && R==0 && C==0) break;
			
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			
			pq.clear();
			
			for(int i=0;i<L;i++) {
				for(int j=0;j<R;j++) {
					String str = br.readLine();
					for(int k=0;k<C;k++) {
						map[i][j][k] = str.charAt(k);
						if(map[i][j][k]=='S') {
							pq.add(new info(i,j,k,0));
							visited[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}
			
			bfs();
			
		}
		System.out.println(sb.toString());

	}
	
	public static void bfs() {
			
		while(!pq.isEmpty()) {
			info temp = pq.poll();
			
			for(int i=0;i<6;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				int nz = temp.z+dz[i];
				
				if(range(nx,ny,nz) &&!visited[nz][nx][ny]) {
					if(map[nz][nx][ny]=='.') {
						visited[nz][nx][ny] = true;
						pq.add(new info(nz,nx,ny,temp.cnt+1));
					}else if(map[nz][nx][ny]=='E') {
						sb.append("Escaped in "+(temp.cnt+1)+" minute(s).\n");
						return;
					}
				}
			}
		}
		sb.append("Trapped!\n");
	}
	
	public static boolean range(int x, int y, int z) {
		return x>=0 && x<R && y>=0 && y<C && z>=0 && z<L;
	}
}
