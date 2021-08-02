package binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_BJ_1300_K번째수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		long left = 1, right = K;
		long result = 0;
		
		while(left<=right) {
			long mid = (left+right)/2;
			long count =0;
			
			for(int i=1;i<=N;i++) {
				count+= Math.min(mid/i, N);
			}
			
			if(count<K) left = mid+1;
			else {
				result = mid;
				right = mid -1;
			}
		}
		bw.write(result + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
