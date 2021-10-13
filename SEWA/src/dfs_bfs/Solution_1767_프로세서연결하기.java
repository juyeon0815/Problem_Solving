import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	
	static int N, coreCnt, coreLen;
	static int [][] map;
	
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	
	static ArrayList<int []> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(i==0 || i==N-1 || j==0 || j==N-1 || map[i][j]==0) continue;
					
					list.add(new int[] {i,j});
				}
			}
			coreCnt = 0;
			coreLen = Integer.MAX_VALUE;
			connection(0,0,0);
			
			sb.append("#"+tc +" "+ coreLen+"\n");
			list.clear();
		}
		System.out.println(sb.toString());
	}
	
	public static void connection(int index, int core, int len) {
		if(index==list.size()) { //여기서 코어개수 갱신 or 길이 비교
			//만약 코어 개수가 더 많을 경우
			if(coreCnt<core) {
				coreCnt = core;
				coreLen = len;
			}else if(coreCnt == core) // 코어 개수가 같은 경우
				coreLen = Math.min(coreLen, len);
			
			return;
		}
		
		//여기서 코어 연결할 수 있나 체크
		
		int x = list.get(index)[0];
		int y = list.get(index)[1];
		for(int i=0;i<4;i++) {
			boolean flag = true;
			
			//벽까지 갈 수 있나 확인
			int nx=x, ny=y;
			while(true) {
				nx+=dx[i];
				ny+=dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) break;
				
				if(map[nx][ny]==1) {
					flag = false;
					break;
				}
				
			}
			
			if(flag) { //연결할 수 있으면 그 연결한 길 1로 변경 하고 다음으로 넘어가기
				int count=0;
				nx=x; ny=y;
				while(true) {
					nx+=dx[i];
					ny+=dy[i];
					
					if(nx<0 || nx>=N || ny<0 || ny>=N) break;
					map[nx][ny] = 1;
					count++;
				}
				
				connection(index+1, core+1, len+count);
				
				//원상태로 복구
				nx=x; ny=y;
				while(true) {
					nx+=dx[i];
					ny+=dy[i];
					
					if(nx<0 || nx>=N || ny<0 || ny>=N) break;
					map[nx][ny] = 0;
				}
				
				
			}else { //연결할 수 없으니 다음 코어로 넘어가기
				connection(index+1, core, len);
			}
		}
		
	}

}
