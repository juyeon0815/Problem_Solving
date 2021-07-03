package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_10814_나이순정렬 {
	
	static class info implements Comparable<info>{
		int index,age;
		String name;
		
		public info(int index, int age, String name) {
			super();
			this.index = index;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(info o) {
			if(this.age==o.age) {
				return this.index-o.index;
			}else return this.age-o.age;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		ArrayList<info> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new info(i,age,name));
		}
		
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i).age+" "+list.get(i).name+"\n");
		}
		System.out.println(sb.toString());
	}

}
