package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5658_보물상자비밀번호 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		
		StringTokenizer st;
		
		List<Character> list = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken())/4; //숫자개수
			int K = Integer.parseInt(st.nextToken()); //k번째수
			
			String num = br.readLine();
			for(int i=0;i<num.length();i++) list.add(num.charAt(i));
			
			for(int i=0;i<N;i++) {
				int count=0;
				for(int j=0;j<num.length();j++) {
					sb.append(list.get(j));
					count++;
					if(count==N) {
						if(!result.contains(sb.toString())) {
							result.add(sb.toString());
						}
						sb.setLength(0);
						count=0;
					}
				}
				char c = list.remove(list.size()-1);
				list.add(0,c);
			}
			
			Collections.sort(result, Collections.reverseOrder());
			
			for(int i=0;i<result.size();i++) {
				if(i==K-1) {
					answer.append("#"+tc+" "+Integer.parseInt(result.get(i),16)+"\n");
					break;
				}
			}
			list.clear();
			result.clear();
			
		}
		System.out.println(answer.toString());

	}

}
