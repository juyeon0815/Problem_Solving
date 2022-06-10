package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_12033_김인천씨의식료품가게 {
	
	static int [] groceries;
	static boolean [] isSelected;
	static int N;
	static boolean success;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			
			sb.append("Case #"+tc+":");
			
			N = Integer.parseInt(br.readLine());
			groceries = new int[N*2];
			isSelected = new boolean[N*2];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N*2;i++) groceries[i] = Integer.parseInt(st.nextToken());
			
			success = false;
			backTracking(0,0);
		}
		
		System.out.println(sb.toString());

	}
	
	public static void backTracking(int cnt, int start) {
		
		if(success) return;
		
		if(cnt==N) {
			cal();
			return;
		}
		
		for(int i=start; i<groceries.length; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			backTracking(cnt+1, i+1);
			isSelected[i] = false;
		}
		
		
	}
	
	public static void cal() {
		StringBuilder sb2 = new StringBuilder();
		List<Integer> productionCost = new ArrayList<>();
		List<Integer> discountedCost = new ArrayList<>();
		
		
		for(int i=0;i<N*2;i++) {
			if(isSelected[i]) discountedCost.add(groceries[i]);
			else productionCost.add((int) (groceries[i]*0.75));
		}
		
		boolean flag = true;
		for(int i=0;i<N;i++) {
			if(productionCost.get(i)!=discountedCost.get(i)) {
				flag = false;
				break;
			}else sb2.append(" "+discountedCost.get(i));
		}
		
		if(flag) {
			sb.append(sb2.toString()+"\n");
			success = true;
		}
	}
}
