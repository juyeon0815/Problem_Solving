package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_12018_YonseiTOTO {
	
	static int n,m;
	static Integer[] mileage;
	static int[]  save;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		save = new int[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			mileage = new Integer[p];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<p;j++) {
				mileage[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(mileage, Collections.reverseOrder());
			
			if(p<l) save[i] = 1;
			else save[i] = mileage[l-1];
			
		}
		
		Arrays.sort(save);
		
		int cnt =0;
		for(int i=0;i<save.length;i++) {
			if(save[i]>36) break; 

			else if(m-save[i]>=0) {
				m-=save[i];
				cnt++;
			}

		}
		
		System.out.println(cnt);

	}

}
