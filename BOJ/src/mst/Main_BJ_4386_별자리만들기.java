package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_4386_별자리만들기 {
	
	public static class constellation {
		int num;
		double x,y;
		
		public constellation(int num, double x, double y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	public static class info implements Comparable<info>{
		int start, end;
		double weight;
		
		public info(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(info o) {
			return (int) (this.weight-o.weight);
		}
	}
	
	static List<info> list;
	static int [] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine()); //별의 개수
		constellation [] cons = new constellation[N];
		
		list = new ArrayList<>();
		parents = new int [N];
		
		for(int i=0;i<N;i++) parents[i] = i;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			cons[i] = new constellation(i, x, y);
		}
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				double distance = Math.sqrt(Math.pow(cons[i].x-cons[j].x, 2) + Math.pow(cons[i].y-cons[j].y,2));
				
				list.add(new info(cons[i].num,cons[j].num,distance));
			}
		}
		
		Collections.sort(list);
		
		double result=0;
		
		for(int i=0;i<list.size();i++) {
			info temp = list.get(i);
			
			if(find(temp.start)!=find(temp.end)) {
				result+=temp.weight;
				union(temp.start,temp.end);
			}
			
		}
		
		System.out.println(result);
		
		

	}
	
	public static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a>b) parents[a] =b;
		else parents[b]= a;
	}

}
