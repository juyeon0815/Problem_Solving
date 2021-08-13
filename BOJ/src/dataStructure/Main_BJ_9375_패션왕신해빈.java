package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_BJ_9375_패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine()); //테스트케이스 수
		
		for(int i=0;i<N;i++) {
			int M = Integer.parseInt(br.readLine()); // 가진 옷 수
			for(int j=0;j<M;j++) {
				st = new StringTokenizer(br.readLine());
				
				String name = st.nextToken();
				String kind = st.nextToken();
				
				if(hm.containsKey(kind)) {
					hm.put(kind, hm.get(kind)+1);
				}
				else hm.put(kind, 1);
			}
			
			int result =1;
			
			for(Entry<String, Integer> elem : hm.entrySet()){
                result = result * (elem.getValue()+1);
            }
			sb.append((result-1)+"\n");
			hm.clear();	
		}
		System.out.println(sb.toString());
	
	}

}
