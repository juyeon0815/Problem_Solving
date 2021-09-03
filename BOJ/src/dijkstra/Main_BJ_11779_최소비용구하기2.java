package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_11779_최소비용구하기2 {
	
	static class info{
		int end, price;

		public info(int end, int price) {
			this.end = end;
			this.price = price;
		}
		
	}
	
	static int N,M, start, end, INF = Integer.MAX_VALUE;
	static int [] distance, sequence;
	static List<info> list[];
	static boolean [] visited;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		distance = new int[N+1];
		visited = new boolean[N+1];
		
		sequence = new int[N+1];
		
		for(int i=1;i<N+1;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			list[start].add(new info(end,price));
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		sequence[start] = -1;
		
		dijkstra();
		
		System.out.println(distance[end]);
		stack.add(end);
		while(true) {
			
			int num =sequence[end];
			end = num;
			if(num==-1) break;
			stack.add(num);
		}
		System.out.println(stack.size());
		while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
	}
	
	public static void dijkstra() {
		int current =0;
		for(int i=0;i<N;i++) {
			current=-1;
			for(int j=1;j<N+1;j++) {
				if(!visited[j] && distance[j]<min) {
					current= j;
				}
			}
			if(current ==end) break;
			
			for(info temp : list[current]) {
				if(!visited[temp.end] && distance[temp.end]>distance[current]+temp.price) {
					distance[temp.end] = distance[current]+temp.price;
					sequence[temp.end] = current;
				}
			}
			visited[current] = true;
		}
	}

}
