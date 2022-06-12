package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_17135_캐슬디펜스 {
	
	static int N,M,D, dieCnt, answer=0;
	static int [][] map, copyMap;
	static List<int []> enemy, copyEnemy, die, archer ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		copyMap = new int[N][M];
		
		enemy = new ArrayList<>();
		copyEnemy = new ArrayList<>();
		die = new ArrayList<>();
		archer = new ArrayList<>();
				
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) copyEnemy.add(new int[] {i,j});
			}
		}
		
		archer(0,0);
		System.out.println(answer);
	}
	
	public static void archer(int cnt, int start) {
		
		if(cnt==3) {
			play();
			return;
		}
		
		for(int i=start;i<M;i++) {
			
			archer.add(new int[] {N,i});
			archer(cnt+1,i+1);
			archer.remove(archer.size()-1);
		}
		
	}
	
	public static void play() {
		dieCnt =0;
		copy();
		
		while(!enemy.isEmpty()) {
			// 궁수랑 적
			target();
			
			//적 한칸 내려가기
			moveEnemy();
		}
		answer = Math.max(answer, dieCnt);
	}
	
	public static void target() {
		int min, x=0,y=0;
		boolean flag = false;
		for(int i=0;i<archer.size();i++) {
			flag = false;
			min = Integer.MAX_VALUE;
			int [] arc = archer.get(i);
			
			for(int j=0;j<enemy.size();j++) {
				int [] ene = enemy.get(j);
				
				int distance = Math.abs(arc[0]-ene[0]+Math.abs(arc[1]-ene[1]));
				if(distance<=D) {
					if(min > distance) {
						min = distance;
						x = ene[0]; y = ene[1];
					} else if(min==distance) {
						if(y>ene[1]) {
							x = ene[0];
							y = ene[1];
						}
					}
					flag = true;
				}
			}
			if(flag)die.add(new int[] {x,y});
		}
		for(int i=0;i<die.size();i++) {
			if(copyMap[die.get(i)[0]][die.get(i)[1]]!=0) dieCnt++;
			copyMap[die.get(i)[0]][die.get(i)[1]]=0;	
		}
		
		die.clear();
	}
	
	public static void moveEnemy() {
		enemy.clear();
		
		for(int i=0;i<M;i++) copyMap[N-1][i] = 0;
		
		
		for(int i=N-2;i>=0 ;i--) {
			for(int j=0;j<M;j++) {
				copyMap[i+1][j] = copyMap[i][j];
				if(copyMap[i][j]==1) enemy.add(new int[] {i+1,j});
				copyMap[i][j]=0;
			}
		}
	}

	public static void copy () {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<copyEnemy.size();i++) {
			enemy.add(copyEnemy.get(i));
		}
	}
}
