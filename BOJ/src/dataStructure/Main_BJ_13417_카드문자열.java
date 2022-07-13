package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_13417_카드문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Deque<String> result;
		Queue<String> card;
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			result = new LinkedList<>();
			card = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				card.add(st.nextToken());
			}
	
			result.add(card.poll());
			while(!card.isEmpty()) {
				char item = card.peek().charAt(0); 
				
				//맨앞에 있는 카드와 비교해서 더 작으면 맨앞에
				if(result.getFirst().charAt(0)>=item) result.addFirst(card.poll());
				//아니면 맨뒤에
				else result.addLast(card.poll());
			}
			
			while(!result.isEmpty()) {
				sb.append(result.poll());
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
