package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		boolean [] minority = new boolean[b+1];
		minority[0]=minority[1]=true;
		for(int i=2;i*i<=b;i++) {
			if(!minority[i]) {
				for(int j=i*i;j<=b;j+=i) minority[j]=true;
			}
		}
		
		for(int i=a;i<=b;i++) {
			if(!minority[i]) sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}

}
