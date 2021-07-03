package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_10800_컬러볼 {
	
	static class info implements Comparable<info> {
		int index,color, size;

		public info(int index, int color, int size) {
			super();
			this.index = index;
			this.color = color;
			this.size = size;
		}

		@Override
		public int compareTo(info o) {
			return this.size-o.size;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		ArrayList<info> list = new ArrayList<>();
		
		
		int N = Integer.parseInt(br.readLine());
		int [] ans = new int [N];
		int [] colorsum = new int [N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list.add(new info(i,color,size));
		}
		
		Collections.sort(list);
		int sum=0;
		for(int i=0, j=0;i<N;i++) {
			info standard = list.get(i);
			info compare = list.get(j);
			
			while(compare.size<standard.size) {
				sum+=compare.size;
				colorsum[compare.color]+=compare.size;
				
				compare = list.get(++j);
			}
			ans[standard.index] = sum-colorsum[standard.color];
		}
		
		for(int i=0;i<N;i++) sb.append(ans[i]+"\n");
		
		System.out.println(sb.toString());

	}
}
