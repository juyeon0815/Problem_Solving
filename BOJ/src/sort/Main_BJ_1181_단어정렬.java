package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_BJ_1181_단어정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(!list.contains(str)) list.add(str);
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) return o1.compareTo(o2);
				return o1.length()-o2.length();
			}
		});
		
		for(int i=0;i<list.size();i++) sb.append(list.get(i)+"\n");
		
		System.out.println(sb.toString());
	}

}
