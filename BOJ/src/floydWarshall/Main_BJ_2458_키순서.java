package floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2458_키순서 {

	static int N,M;
	static int [][] student;
	static boolean [] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		student = new int [N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			student[a][b] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<N+1;i++) {

			check = new boolean[N+1];
			
			for(int j=1;j<N+1;j++) {
				if(student[i][j]==1) queue.add(j);
			}
			
			while(!queue.isEmpty()) {
				int tmp = queue.poll();
				
				for(int j=1;j<N+1;j++) {
					if(student[tmp][j]==1 && !check[j]) {
						check[j] = true;
						student[i][j] = 1;
						queue.add(j);
					}
				}
			}
		}
		
		for(int i=1;i<N+1;i++) {
			student[i][i] = 1;
			for(int j=1;j<N+1;j++) {
				if(student[i][j]==1) student[j][i] = 1;
			}
		}
		
		int cnt=0, result=0;
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(student[i][j]==1) cnt++;
			}
			if(cnt==N) result++;
			cnt=0;
			
		}
		
		System.out.println(result);
		
	}

}
