package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1735_분수합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		
		int up = a1*b2 + a2*b1;
		int down = a2*b2;
		
		int upResult = up/gdc(up,down);
		int downResult = down/gdc(up,down);
		
		System.out.println(upResult+" "+ downResult);

	}
	
	public static int gdc(int a, int b) {
		if(b==0) return a;
		return gdc(b,a%b);
	}
}
