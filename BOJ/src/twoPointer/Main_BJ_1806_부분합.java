package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //수열 길이
		int S = Integer.parseInt(st.nextToken()); // 합 S이상
		
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int start=0, end=0, len=N+1, sum=0;
		while(true) {
			if(sum>=S) { //길이 비교
				if(end-start<len) len = end-start;
				sum-=arr[start++];
			}
			else if(end==N) break;
			else sum+=arr[end++];
		}
		
		if(len==N+1) System.out.println(0); //합을 만드는 것이 불가능하다면 0출력
		else System.out.println(len);
	}

}
