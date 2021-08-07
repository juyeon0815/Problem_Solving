package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_1620_나는야포켓몬마스터이다솜2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, String> hmInt = new HashMap<>();
		HashMap<String, Integer> hmString = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			String name = br.readLine();
			hmInt.put(i, name);
			hmString.put(name, i);
		}
		
		boolean isNumber;
		for(int i=0;i<M;i++) {
			String command = br.readLine();
			isNumber = command.matches("[+-]?\\d*(\\.\\d+)?");
			if(isNumber) { //숫자인경우
				int num = Integer.parseInt(command);
				sb.append(hmInt.get(num)+"\n");
			}else {
				sb.append(hmString.get(command)+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}
