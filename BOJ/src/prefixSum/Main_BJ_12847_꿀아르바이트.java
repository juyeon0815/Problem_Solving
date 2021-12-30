package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_12847_꿀아르바이트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); //일을 할 수 있는 날
		
		int [] day = new int[n];
		
		long sum=0, max=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			day[i] = Integer.parseInt(st.nextToken());
			if(i<m) sum+=day[i];
		}
		
		max = sum;
		
		for(int i=m;i<n;i++) {
			sum+=day[i]-day[i-m];
			
			if(sum>max) max = sum;
		}
		
		System.out.println(max);
	}

}
