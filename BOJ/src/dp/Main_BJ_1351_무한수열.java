package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BJ_1351_무한수열 {
	
	static Long N;
	static int P,Q;
	static Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken()); //An
		P = Integer.parseInt(st.nextToken()); 
		Q = Integer.parseInt(st.nextToken());
		
		System.out.println(cal(N));
	}
	
	public static long cal(Long N) {
		
		if(N==0) return 1;
		
		if(map.containsKey(N)) return map.get(N);
		
		long p = (long) Math.floor(N/P);
		long q = (long) Math.floor(N/Q);
		
		map.put(N, cal(p)+cal(q));
		return map.get(N);
		
	}

}
