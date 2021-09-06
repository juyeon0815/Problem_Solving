package segmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2042_구간합구하기 {
	
	static int N,M,K;
	static long [] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 수
		M = Integer.parseInt(st.nextToken()); //수의 변경이 일어나는 횟수
		K = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수
		
		arr = new long[N];
		tree = new long[arr.length*4];
		
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
		
		init(1,0,arr.length-1); //트리만들기
		
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 1인경우 b번째 수를 c로 , 2인경우 b번째수부터 c번째 수까지의 합 구하기
			int b = Integer.parseInt(st.nextToken())-1; 
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) { //값 변경
				long diff = c - arr[b];
				update(1,0,arr.length-1,b,diff);
				arr[b] = c;
			}else { //구간 합 구하기
				sb.append(sum(1,0,arr.length-1,b,(int)(c-1))).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static long init(int node_idx, int start, int end) {
		if(start==end) return tree[node_idx] = arr[start];
		
		return tree[node_idx] = init(node_idx*2, start, (start+end)/2) + init(node_idx*2+1, (start+end)/2+1, end);
	}
	
	public static void update(int node_idx, int start, int end, int idx, long diff) {
		if(idx < start | idx> end) return;
		tree[node_idx]+=diff;
		if(start!=end) {
			update(node_idx*2,start,(start+end)/2,idx,diff);
			update(node_idx*2+1, (start+end)/2+1, end, idx, diff);
		}
	}
	
	public static long sum(int node_idx, int start, int end, int L, int R) {
		if(end<L || start>R) return 0;
		
		if(L<=start && end<=R) return tree[node_idx];
		
		return sum(node_idx*2, start, (start+end)/2,L,R)+ sum(node_idx*2+1, (start+end)/2+1, end, L,R);
		
	}

}
