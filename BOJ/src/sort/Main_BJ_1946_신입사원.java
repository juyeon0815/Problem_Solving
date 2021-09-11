package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1946_신입사원 {
	
	static class info implements Comparable<info>{
		int document, interview;

		public info(int document, int interview) {
			super();
			this.document = document;
			this.interview = interview;
		}

		@Override
		public int compareTo(info o) {
			return this.document-o.document;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		ArrayList<info> list = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			
			int N = Integer.parseInt(br.readLine());
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				list.add(new info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			
			Collections.sort(list);
			
			int count=1;
			int min = list.get(0).interview;
			for(int j=1;j<list.size();j++) {
				if(list.get(j).interview<min) {
					count++;
					min = list.get(j).interview;
				}
			}
			sb.append(count+"\n");
			list.clear();
		}
		System.out.println(sb.toString());
	}
}
