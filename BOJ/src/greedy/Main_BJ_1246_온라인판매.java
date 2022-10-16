package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1246_온라인판매 {
	
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) list.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(list, Collections.reverseOrder());
		
		int size = N;
		if(N>M) size = M;
		
		
		int max = 0, price=0;
		for(int i=0;i<size;i++) {
			
			int cal = list.get(i)*(i+1);

			if(max<cal) {
				max = cal;
				price = list.get(i); 
			}
		}
		
		System.out.println(price +" " + max);
		
	}

}
