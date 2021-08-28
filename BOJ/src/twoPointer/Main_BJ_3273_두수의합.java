package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_3273_두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int left=0, right=N-1, count=0;
		
		while(left<right) {
			
			int sum = arr[left]+arr[right];
			
			if(sum<=x) {
				left++;
				if(sum==x) count++;
			}
			else if(sum>x) right--;
		}
		
		System.out.println(count);
	}

}
