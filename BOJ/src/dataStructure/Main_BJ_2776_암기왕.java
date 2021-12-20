package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_2776_암기왕 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashMap<Integer, Boolean> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수
		
		for(int i=0;i<T;i++) {
			hm.clear();
			int N = Integer.parseInt(br.readLine()); //정수의 개수
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				hm.put(Integer.parseInt(st.nextToken()), true);
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				if(hm.containsKey(Integer.parseInt(st.nextToken()))) sb.append("1\n");
				else sb.append("0\n");
			}
			
		}
		System.out.println(sb.toString());

	}

}
