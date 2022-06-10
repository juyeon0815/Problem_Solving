package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_12033_김인천씨의식료품가게_list {
	
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			answer = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N*2;i++) list.add(Integer.parseInt(st.nextToken()));
			
			Collections.reverse(list);
			
			while(!list.isEmpty()) {
				int price = (int) ((int)list.remove(0)*0.75);
				for(int i=0;i<list.size();i++) {
					if(list.get(i)==price) {
						answer.add(price);
						list.remove(i);
						break;
					}
				}
			}
			
			Collections.reverse(answer);
			System.out.print("Case #"+tc+": ");
			for(int i=0;i<answer.size();i++) {
				System.out.print(answer.get(i)+" ");
			}
			System.out.println();	
		}
	}
}
