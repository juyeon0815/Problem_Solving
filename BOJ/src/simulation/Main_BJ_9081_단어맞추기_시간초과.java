package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_9081_단어맞추기_시간초과 {
	
	static char [] alpabet, check;
	static boolean[] visited;
	static String word;
	static ArrayList<String> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			word = br.readLine();
			
			alpabet = new char[word.length()];
			check = new char[word.length()];
			visited = new boolean[word.length()];
			
			for(int j=0;j<word.length();j++) alpabet[j] = word.charAt(j);
			
			perm(0);
			Collections.sort(list);
			for(int j=0;j<list.size();j++) {
				if(list.get(j).equals(word)) {
					if(j==list.size()-1) answer.append(word+"\n");
					else answer.append(list.get(j+1)+"\n");
					break;
				}
			}
		}
		System.out.println(answer.toString());

	}
	
	public static void perm(int cnt) {
		if(cnt==word.length()) {
			for(int i=0;i<word.length();i++) {
				sb.append(check[i]);
			}
			if(!list.contains(sb.toString())) list.add(sb.toString());
			sb.setLength(0);
		}
		
		for(int i=0;i<word.length();i++) {
			if(!visited[i]) {
				check[cnt]= alpabet[i];
				visited[i] = true;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}
