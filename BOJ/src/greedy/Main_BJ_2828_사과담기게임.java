package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2828_사과담기게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		int J = Integer.parseInt(br.readLine());
		
		int result=0, Lbasket=1, Rbasket=M;
		for(int i=0;i<J;i++) {
			int apple = Integer.parseInt(br.readLine());
			
			if(Lbasket<=apple && apple<=Rbasket) continue;
			
			
			if(Lbasket>apple) {
				result+=Lbasket-apple;
				Rbasket-=Lbasket-apple;
				Lbasket=apple;
			}else {
				result+=apple-Rbasket;
				Lbasket+=apple-Rbasket;
				Rbasket=apple;
			}
		}
		
		System.out.println(result);
	}

}
