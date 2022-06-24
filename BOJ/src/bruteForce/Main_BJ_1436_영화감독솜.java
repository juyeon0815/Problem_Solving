package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_1436_영화감독솜 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//666 1666 2666 3666 4666 5666 6666 7666 8666 9666 10666 
		
		int answer =0;
		for(int i=666; i<Integer.MAX_VALUE;i++) {
			if(check(i)) answer++;
			
			if(answer==N) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static boolean check(int num) {
		String str = Integer.toString(num);
		
		int cnt=0;
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)=='6') cnt++;
			else cnt=0;
			
			if(cnt>=3) return true;
		}
		
		return false;
	}

}
