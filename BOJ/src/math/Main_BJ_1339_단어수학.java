package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_BJ_1339_단어수학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer [] alphabet = new Integer[26];
		Arrays.fill(alphabet, 0);
		
		for(int i=0;i<N;i++) {
			char[] word = br.readLine().toCharArray();
			
			int position = 1;
			for(int j=word.length-1;j>=0;j--) {
				alphabet[word[j]-65]+= position;
				position*=10;
			}
		}
		
		Arrays.sort(alphabet, Collections.reverseOrder());
		
		int num=9, answer=0;
		
		for(int i=0;i<alphabet.length;i++) {
			if(alphabet[i]==0) break;
			answer+=alphabet[i]*num;
			num--;
		}
		
		System.out.println(answer);
		
	}
}
