package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_14226_이모티콘 {
	
	public static class info {
		int emoticonCnt, clipBoard, cnt;

		public info(int emoticonCnt, int clipBoard, int cnt) {
			super();
			this.emoticonCnt = emoticonCnt;
			this.clipBoard = clipBoard;
			this.cnt = cnt;
		}
		
	}
	
	public static boolean [][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		visited = new boolean[2001][2001]; //[이모티콘 개수][클립보드개수]
		int result = bfs(S);
		System.out.println(result);
	}
	
	public static int bfs(int S) {
		Queue<info> queue = new LinkedList<>();
		
		queue.add(new info(1,0,0));
		visited[1][0] = true;
		
		while(!queue.isEmpty()) {
			info temp = queue.poll();
			
			if(temp.emoticonCnt==S) {
				return temp.cnt;
			}
			
			// 복사
			if(temp.emoticonCnt>0 && temp.emoticonCnt<2000 && !visited[temp.emoticonCnt][temp.emoticonCnt]) {
				queue.add(new info(temp.emoticonCnt,temp.emoticonCnt,temp.cnt+1));
				visited[temp.emoticonCnt][temp.emoticonCnt] = true;
			}
			
			
			if(temp.clipBoard>0 && temp.emoticonCnt+temp.clipBoard<2000) {
				if(!visited[temp.emoticonCnt+temp.clipBoard][temp.clipBoard]) {
					queue.add(new info(temp.emoticonCnt+temp.clipBoard,temp.clipBoard,temp.cnt+1));
					visited[temp.emoticonCnt+temp.clipBoard][temp.clipBoard]= true;
				}
			}
			
			if(temp.emoticonCnt>0 && temp.emoticonCnt<2000 &&!visited[temp.emoticonCnt-1][temp.clipBoard]) {
				queue.add(new info(temp.emoticonCnt-1,temp.clipBoard,temp.cnt+1));
				visited[temp.emoticonCnt-1][temp.clipBoard] = true;
			}
			
			
		}
		
		return 0;
		
	}
	

}
