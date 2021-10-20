package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_BJ_1406_에디터_시간초과 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Character> list = new LinkedList<>();
		
		String command = br.readLine();
		
		for(int i=0;i<command.length();i++) {
			list.add(command.charAt(i));
		}
		
		int index = list.size();
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			char com = str.charAt(0);
			if(str.length()==1) {
				if(com=='L' && index>0) index--;
				else if(com=='D' && index<list.size()) index++;
				else if(com=='B' && index>0) {
					list.remove(index-1); 
					index--;
				}
			}else {
				char add = str.charAt(2);
				list.add(index,add);
				index++;
			}
		}
		
		for(int i=0;i<list.size();i++) sb.append(list.get(i));
		System.out.println(sb.toString());
	}

}
