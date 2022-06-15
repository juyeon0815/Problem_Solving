package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_BJ_1431_시리얼번호 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length()) return -1;
				else if(o1.length()==o2.length()) {
					if(sum(o1)==sum(o2)) {
						return o1.compareTo(o2);
					}else return Integer.compare(sum(o1), sum(o2));
				}
				return 1;
			}
			
		});
		
		
		for(int i=0;i<list.size();i++) sb.append(list.get(i)+"\n");
		
		System.out.println(sb.toString());
		
	}
	
	public static int sum(String s) {
		int sum =0;
		for(int i=0;i<s.length();i++) {
			if('0'<=s.charAt(i) && s.charAt(i)<='9') sum+=s.charAt(i)-48;
		}
		
		return sum;
	}

}
