package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_2303_숫자게임 {
	
	static class Info implements Comparable<Info>{
		int index, max;

		public Info(int index, int max) {
			this.index = index;
			this.max = max;
		}

		@Override
		public int compareTo(Info o) {
			if(this.max == o.max) return (o.index-this.index);
			return (this.max-o.max)*-1;
		}
		
	}
	
	static List<Integer> list[], select;
	static List<Info> result = new ArrayList<>();
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		select = new ArrayList<>();
		
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=1;i<=N;i++) {
			max = 0;
			bruteForce(0,i,0);
			result.add(new Info(i,max));
		}
		
		Collections.sort(result);
		
		System.out.println(result.get(0).index);

	}
	
	public static void bruteForce(int cnt, int index, int start) {
		if(cnt==3) {
			cal();
			return;
		}
		
		for(int i=start;i<list[index].size();i++) {
			select.add(list[index].get(i));
			bruteForce(cnt+1,index,i+1);
			select.remove(select.size()-1);
		}
	}
	
	public static void cal() {
		int sum=0;
		for(int i=0;i<select.size();i++) {
			sum+=select.get(i);
		}
		
		String last = Integer.toString(sum);
		sum = last.charAt(last.length()-1)-48;
		max = Math.max(max, sum);
	}

}
