package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1477_휴게소세우기 {
	
	static int N,M,L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //현재 휴게소 개수
		M = Integer.parseInt(st.nextToken()); //더 지으려고하는 휴게소 개수
		L = Integer.parseInt(st.nextToken()); //고속도로 길이
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) list.add(Integer.parseInt(st.nextToken()));
		
		list.add(0);
		list.add(L);
		
		Collections.sort(list);
		
		int left=1, right=L;
		while(left<=right) {
			int mid = (left+right)/2;
			
			int cut=0;
			for(int i=0;i<list.size()-1;i++) {
				cut+=(list.get(i+1)-list.get(i)-1)/mid; //휴게소 사이에 몇개 지을 수 있는지
			}
			if(cut>M) left = mid+1;
			else right = mid-1;
		}
		System.out.println(left);
	}
}
