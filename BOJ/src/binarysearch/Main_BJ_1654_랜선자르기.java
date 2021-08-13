package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); //가지고 있는 랜선 개수
		long N = Integer.parseInt(st.nextToken()); //필요한 랜선 개수
		
		long [] lan = new long[K];
		
		
		long left=1, right = 0;
		
		for(int i=0;i<K;i++) {
			lan[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, lan[i]);
		}
		
		while(left<=right) {
			long mid = (left+right)/2;
			
			long result=0;
			for(int i=0;i<lan.length;i++) {
				result+=lan[i]/mid;
			}
			
			if(result<N) {
				right = mid-1;

			}else {
				left=mid+1;
			}
		}
		System.out.println(right);
	}

}
