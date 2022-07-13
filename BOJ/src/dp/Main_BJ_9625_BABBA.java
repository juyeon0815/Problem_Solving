package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_9625_BABBA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int [] A = new int[K+1];
		int [] B = new int[K+1];
		
		A[0] = 1; B[0] = 0;
		
		for(int i=1;i<=K;i++) {
			A[i] = B[i-1];
			B[i] = A[i-1] + B[i-1];
		}
		
		System.out.println(A[K]+" "+ B[K]);

	}

}
