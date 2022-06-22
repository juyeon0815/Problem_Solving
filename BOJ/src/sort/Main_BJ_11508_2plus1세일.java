package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_BJ_11508_2plus1세일 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Integer [] price = new Integer[N];
		
		for(int i=0;i<N;i++) price[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(price,Comparator.reverseOrder());
		
		int sum=0;
		for(int i=0;i<price.length;i++) {
			if((i+1)%3==0) continue;
			sum+=price[i];
		}
		System.out.println(sum);
	}

}
