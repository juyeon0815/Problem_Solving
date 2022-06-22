package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_BJ_16637_괄호추가하기 {
	
	static List<Integer> number;
	static List<Character> operator;

	static int max =Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		number = new ArrayList<Integer>();
		operator = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		String line = br.readLine();
		
		for(int i=0;i<N;i++) {
			char c = line.charAt(i);
			if(c=='+' || c=='-' || c=='*') operator.add(c);
			else number.add(c-48);
		}
		
		dfs(0,number.get(0)); 
		System.out.println(max);

	}
	
	public static void dfs(int cnt, int sum) {
		
		if(cnt >= operator.size()) {
			max = Math.max(max, sum);
			return;
		}
	
		//괄호안칠때
		dfs(cnt+1, cal(sum,number.get(cnt+1), operator.get(cnt)));
		
		//괄호 칠때
		if(cnt+1<operator.size()) {
			int value = cal(number.get(cnt+1), number.get(cnt+2), operator.get(cnt+1));
			dfs(cnt+2, cal(sum, value, operator.get(cnt)));
		}	
	}
	
	public static int cal(int num1, int num2, char oper) {
		if(oper=='+') return num1+num2;
		else if(oper=='-') return num1-num2;
		else return num1*num2;

	}

}
