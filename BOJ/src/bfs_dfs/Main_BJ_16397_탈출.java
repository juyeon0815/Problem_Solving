package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16397_탈출 {
	
	static int N,T,G;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 초기 수
		T = Integer.parseInt(st.nextToken()); // 버튼 누를 수 있는 최대 수
		G = Integer.parseInt(st.nextToken()); // 똑같이 만들어야하는 수
		
		int res = bfs();
		System.out.println(res==-1?"ANG":res);

	}
	
	public static int bfs() {

		Queue<int []> queue = new LinkedList<>();
		boolean [] visited = new boolean[100000];
		queue.add(new int[] {N,0});
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int [] item = queue.poll();
			
			
			if(item[1]>T) return -1;
			
			if(item[0]==G) {
				return item[1];
			}
			
			//A 눌렀을 때,
			if(item[0]+1<100000 && !visited[item[0]+1]) {
				visited[item[0]+1] = true;
				queue.add(new int[] {item[0]+1, item[1]+1});
			}
			
			//B 눌렀을 때,
			int B = item[0]*2;
			if(B>99999) continue;
			String num = Integer.toString(B);
			B-= Math.pow(10, num.length()-1);
			if(B>=0 && B<100000 && !visited[B]) {
				visited[B]=true;
				queue.add(new int[] {B,item[1]+1});
			}
		}
		return -1;
	}

}
