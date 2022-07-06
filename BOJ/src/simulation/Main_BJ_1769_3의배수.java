package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_BJ_1769_3의배수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		
		int sum, cnt=0;;
		while(num.length()>1) {
			
			sum = 0;
			for(int i=0;i<num.length();i++) {
				sum+= num.charAt(i)-48;
			}
			num = Integer.toString(sum);
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(Integer.parseInt(num)%3==0?"YES":"NO");
	}

}
