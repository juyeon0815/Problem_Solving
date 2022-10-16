package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_16120_PPAP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String line = br.readLine();
		
			boolean flag = true;
			for(int i=0;i<line.length();i++) {
				char alpabet = line.charAt(i);

				if(alpabet=='P') stack.add(alpabet);
				else {
					if(stack.size()<2 || i==line.length()-1 || line.charAt(i+1)=='A') {
						flag = false;
						break;
					}
					
					else {
						stack.pop();
						i++;
					}
				}
			}
			
			if(stack.size()>1) flag = false;
			System.out.println(flag?"PPAP":"NP");
	}

}
