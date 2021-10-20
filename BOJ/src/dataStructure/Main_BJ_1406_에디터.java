package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main_BJ_1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> list = new LinkedList<>();
		
		String command = br.readLine();
		
		for(int i=0;i<command.length();i++) {
			list.add(command.charAt(i));
		}
		
		ListIterator<Character> liter = list.listIterator();
		while (liter.hasNext()) {
			liter.next(); 
		}

		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			char com = str.charAt(0);
			if(com=='L') {
				if(liter.hasPrevious()) liter.previous();
			}
			else if(com=='D') {
				if(liter.hasNext()) liter.next();
			}
			else if(com=='B') {
				if(liter.hasPrevious()) { 
					liter.previous(); 
					liter.remove(); 
				}
			}
			else if(com=='P') {
				liter.add(str.charAt(2));
			}
		}
		
		for (char c : list) { 
			sb.append(c);
		} 
		
		System.out.println(sb.toString());
	}

}
