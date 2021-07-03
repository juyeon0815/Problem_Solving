package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_10800_컬러볼_시간초과 {
	
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
		int [] sum = new int [N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list.add(new info(i,color,size));
		}
		
		Collections.sort(list);
		
		for(int i=1;i<N;i++) {
			info temp = list.get(i);
			for(int j=i-1;j>=0;j--) {
				if(temp.color!=list.get(j).color && temp.size>list.get(j).size) sum[temp.index]+=list.get(j).size;
			}
		}
		
		for(int i=0;i<N;i++) sb.append(sum[i]+"\n");
		
		System.out.println(sb.toString());

	}
}
