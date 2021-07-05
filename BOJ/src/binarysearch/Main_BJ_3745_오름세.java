package binarysearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_BJ_3745_오름세 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int [] arr;
		
		while(scan.hasNext()) {
			
			int n = scan.nextInt();
			arr = new int[n];
			list.add(0);
			
			for(int i=0;i<n;i++) arr[i] = scan.nextInt();
			
			for(int i=0;i<n;i++) {
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
			list.clear();
		}
	}
}
