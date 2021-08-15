package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2607_비슷한단어 { //하나의 문자를 더하거나 빼거나 바꾸거나

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alpha = new int[26];
		
		int N = Integer.parseInt(br.readLine()); //단어 수
		
		String word = br.readLine();
		for(int i=0;i<word.length();i++) {
			alpha[word.charAt(i)-'A']++;
		}
		
		int same, result=0;
		for(int i=0;i<N-1;i++) {
			
			int [] copy = new int[26];
			for(int j=0;j<copy.length;j++) copy[j] = alpha[j];
			
			same=0;
			String check = br.readLine();
			for(int j=0;j<check.length();j++) {
				if(copy[check.charAt(j)-'A']>0) {
					same++;
					copy[check.charAt(j)-'A']--;
				}
			}
			if(check.length()+1== word.length() && same==check.length()) { //한 문자를 추가해야 하는 경우
				result++;
			}else if(check.length()-1==word.length() && same==word.length()) { //한 문자를 빼야하는 경우
				result++;
			}else if(check.length()==word.length()) {//바꿔야하는 경우
				if(same==word.length() || same==word.length()-1) {
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
