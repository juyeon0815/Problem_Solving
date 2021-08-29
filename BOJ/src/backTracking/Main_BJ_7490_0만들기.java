package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_7490_0만들기 {
	
	static char [] symbol = {' ', '+','-'};
	static char [] select;
	
	static StringBuilder sb = new StringBuilder();
	static StringBuilder result = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int N  = Integer.parseInt(br.readLine());
			select = new char[N-1];
			backTracking(N,0);
			result.append("\n");
		}
		System.out.println(result.toString());
	}
	
	public static void backTracking(int N, int cnt) {
		if(cnt == N-1) {
			sb.append(1);
			for(int i=0;i<select.length;i++) {
				sb.append(select[i]+""+(i+2));
			}
			cal();
			sb.setLength(0);
			return;
		}
		
		for(int i=0;i<3;i++) {
			select[cnt] = symbol[i];
			backTracking(N, cnt+1);
		}	
	}
	
	public static void cal() {
		String cal = sb.toString();
		cal = cal.replace(" ", "");
		cal = cal.replace("+", " + ");
		cal = cal.replace("-", " - ");
		st = new StringTokenizer(cal);
		
		int answer=Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()) {
			String command = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(command.equals("+")) answer+=num;
			else if(command.equals("-")) answer-=num;
		}
		
		if(answer==0) result.append(sb.toString()+"\n");
	}

}
