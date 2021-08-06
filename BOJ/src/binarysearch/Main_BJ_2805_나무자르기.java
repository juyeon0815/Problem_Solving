package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2805_나무자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //나무 수
		int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이
		
		int []trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		long left = 1, right =0;
		
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, trees[i]);
		}
		
		long answer =0;
		while(left<=right) {
			long mid = (left+right)/2;
			long cut=0;
			
			for(int i=0;i<N;i++) {
				cut += Math.max(0, trees[i]-mid);
			}
			
			if(cut>=M) left = mid+1;
			else {
				right = mid-1;
				answer = right;
			}
		}
		System.out.println(answer);
	}
}
