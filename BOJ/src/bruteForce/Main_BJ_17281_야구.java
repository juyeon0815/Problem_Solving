package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17281_야구 {
	
	static int N, ans;
	static int [][] player;
	static boolean [] isSelected;
	static int [] turn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		player = new int[N+1][10];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<10;j++) player[i][j] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[10];
		turn = new int[10];
		
		isSelected[4] = true;
		turn[4]=1;
		
		perm(2);
		System.out.println(ans);

	}
	
	public static void perm(int cnt) {
		if(cnt==10) {
			play();
			return;
		}
		
		for(int i=1;i<10;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			turn[i] = cnt;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void play() {
		boolean[] base;
		
		int start = 1, score=0;
		for(int i=1;i<=N;i++) {
			int out=0;
			base = new boolean[4];
			
			loop:
			while(true) {
				
				for(int j=start;j<=9;j++) {
					int result =  player[i][turn[j]];
					
					if(result==0) { //아웃
						out++;
					}else if(result==1) { //안타
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								if(k==3) {
									score++;
									base[k] = false;
								}else {
									base[k] = false;
									base[k+1] = true;
								}
							}
						}
						base[1] = true;
						
					}else if(result==2) { //2루타
						
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								if(k==3 || k==2) {
									score++;
									base[k] = false;
								}else {
									base[k] = false;
									base[k+2] = true;
								}
							}
						}
						base[2] = true;
						
					}else if(result==3) { //3루타
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								score++;
								base[k] = false;
							}
						}
						base[3] = true;
						
					}else { //홈런
						for(int k=3;k>=1;k--) {
							if(base[k]) {
								score++;
								base[k] = false;
							}
						}
						score++;
					}
					
					if(out==3) {
						start = j+1;
						if(start==10) start=1;
						break loop;
					}
				}start = 1;
			}
		}
		ans = Math.max(ans, score);
	}

}
