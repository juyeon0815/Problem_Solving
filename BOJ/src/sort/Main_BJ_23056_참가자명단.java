package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_23056_참가자명단 {
	
	public static class info implements Comparable<info>{
		int num;
		String name;
		
		public info(int num, String name) {
			super();
			this.num = num;
			this.name = name;
		}

		@Override
		public int compareTo(info o) {
			if(this.num==o.num) {
				if(this.name.length()==o.name.length()) return this.name.compareTo(o.name);
				return this.name.length() - o.name.length();
			}
			return this.num-o.num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		ArrayList<info> odd = new ArrayList<>(); //홀
		ArrayList<info> even = new ArrayList<>(); //짝
		
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] school = new int[N+1];
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			if(num==0 && name.equals("0")) break;
			
			if(num%2==0 && school[num]<M) {
				even.add(new info(num, name));
				school[num]++;
			}
			else if(num%2==1 && school[num]<M) {
				odd.add(new info(num,name));
				school[num]++;
			}
		}
		
		Collections.sort(odd);
		Collections.sort(even);
		
		for(int i=0;i<odd.size();i++) {
			sb.append(odd.get(i).num+" "+odd.get(i).name+"\n");
		}
		
		for(int i=0;i<even.size();i++) {
			sb.append(even.get(i).num+" "+even.get(i).name+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
