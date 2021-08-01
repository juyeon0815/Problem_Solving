package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_BJ_2002_추월 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			hm.put(br.readLine(), i);
		}
		
		int count=0;
		boolean [] overtaking = new boolean[N];
		for(int i=0;i<N;i++) {
			int car = hm.get(br.readLine());
			for(int j=0;j<car;j++) {
				if(!overtaking[j]) {
					count++;
					break;
				}
			}
			overtaking[car] = true;
		}
		System.out.println(count);
	}
}
