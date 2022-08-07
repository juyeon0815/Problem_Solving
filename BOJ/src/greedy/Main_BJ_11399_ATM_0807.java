package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_11399_ATM_0807 {
	
	static class info implements Comparable<info>{
		int index, time;

		public info(int index, int time) {
			this.index = index;
			this.time = time;
		}

		@Override
		public int compareTo(info o) {
			if(o.time==this.time) return this.index-o.index;
			return this.time-o.time;
		}
	}
	
	static List<info> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) list.add(new info(i,Integer.parseInt(st.nextToken())));
		
		Collections.sort(list);
		
		int result=0, sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).time;
			result+=sum;
		}
		
		System.out.println(result);

	}

}
