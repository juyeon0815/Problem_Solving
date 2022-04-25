package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_2309_일곱난쟁이2 {
	
	static int n=9;
	static ArrayList<Integer> dwarf = new ArrayList<>();
	static boolean [] select;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		select = new boolean[n];
		
		for(int i=0;i<n;i++) {
			dwarf.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(dwarf);
		
		selectDwarf(0,0);

	}
	
	public static void selectDwarf(int cnt, int start) {
		if(cnt ==7) {
			findRealDwarf();
			return;
		}
		
		for(int i=start; i<n;i++) {
			if(select[i]) continue;
			select[i] = true;
			selectDwarf(cnt+1, i+1);
			select[i] = false;
		}
	}
	
	public static void findRealDwarf() {
		StringBuilder sb = new StringBuilder();
		int sum=0;
		for(int i=0;i<n;i++) {
			if(select[i]) {
				sum+=dwarf.get(i);
				sb.append(dwarf.get(i)+"\n");
			}
		}
		
		if(sum==100) {
			System.out.println(sb.toString());
			System.exit(0);
		}
		
	}

}
