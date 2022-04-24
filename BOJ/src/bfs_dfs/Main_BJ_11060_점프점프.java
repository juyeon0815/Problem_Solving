package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11060_점프점프 {
		
	static int [] maze, count;
	static int n;
	static Queue<Integer> queue =new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		maze = new int[n];
		count = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			maze[i] = Integer.parseInt(st.nextToken());
			count[i] = Integer.MAX_VALUE;
		}
		
		findWay();
	}
	
	public static void findWay() {
		queue.add(0);
		count[0]= 0;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=1;i<=maze[temp];i++) {
				if(range(temp+i)) {
					if(count[temp+i]> count[temp]+1) {
						count[temp+i]= count[temp]+1;
						queue.add(temp+i);
					}
				}
			}
			
		}
		if(count[n-1]== Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(count[n-1]);
	}
	
	public static boolean range(int x) {
		return x>=0 && x<n;
	}

}
