package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_12764_싸지방에간준하_TLE {
	
	static class Info{
		int start, end;

		public Info(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Info [start=" + start + ", end=" + end + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				return o1.start-o2.start;
			}
		});
		
		List<int []> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		boolean change = false;
		while(!pq.isEmpty()) {
			Info temp = pq.poll();

			if(list.size()==0) {
				list.add(new int[] {temp.end,1});
			}else {
				for(int i=0;i<list.size();i++) {
					if(list.get(i)[0]<=temp.start) {
						list.set(i, new int[] {temp.end, (list.get(i)[1]+1)});
						change = true;
						break;
					}
				}
				if(!change) {
					list.add(new int[] {temp.end,1});
				}
			}change =false;
		}
		
		sb.append(list.size()+"\n");
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)[1]+" ");
		}
		System.out.println(sb.toString());

	}

}
