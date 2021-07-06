package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_12015_가장긴증가하는부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int []arr = new int[N];
		list.add(0);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			if(list.get(list.size()-1)<arr[i]) list.add(arr[i]);
			else {
				int left = 1;
				int right = list.size()-1;
				
				while(left<right) {
					int mid = (left+right)/2;
					if(list.get(mid)<arr[i]) left=mid+1;
					else right = mid;
				}
				list.set(right, arr[i]);
			}
		}
		System.out.println(list.size()-1);

	}

}
