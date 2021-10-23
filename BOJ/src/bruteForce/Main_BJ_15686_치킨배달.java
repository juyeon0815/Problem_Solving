package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_15686_치킨배달 {
	
	static class info{
		int x, y;

		public info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N,M, min=Integer.MAX_VALUE;
	static int [][] map;
	
	static ArrayList<info> chicken = new ArrayList<>();
	static ArrayList<info> choice = new ArrayList<>();
	static ArrayList<info> home = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) chicken.add(new info(i,j));
				else if(map[i][j]==1) home.add(new info(i,j));
			}
		}
		
		comb(0,0);
		System.out.println(min);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==M) {
			check();
			return;
		}
		
		for(int i=start;i<chicken.size();i++) {
			choice.add(new info(chicken.get(i).x, chicken.get(i).y));
			comb(cnt+1, i+1);
			choice.remove(choice.size()-1);
		}
	}
	
	public static void check() {
		int distance, sum=0;
		for(int i=0;i<home.size();i++) {
			distance=Integer.MAX_VALUE;
			for(int j=0;j<choice.size();j++) {
				distance = Math.min(distance, Math.abs(home.get(i).x-choice.get(j).x)+Math.abs(home.get(i).y-choice.get(j).y));
			}
			sum+=distance;
		}
		
		min = Math.min(min, sum);
	}

}
