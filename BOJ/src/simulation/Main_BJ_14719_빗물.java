package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int [] map = new int[W];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int left, right, compare, sum=0;
		for(int i=1;i<W-1;i++) {
			left=right=0;
			
			for(int j=0;j<i;j++) {
				left = Math.max(left, map[j]);
			}
			
			for(int j=i+1;j<W;j++) {
				right = Math.max(right, map[j]);
			}
			
			if(map[i]<left && map[i]<right) {
				compare = Math.min(left,right);
				sum+=compare-map[i];
			}
		}
		System.out.println(sum);
	}

}
