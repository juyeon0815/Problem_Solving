package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_2309_일곱난쟁이 {
	
	static boolean [] select;
	static int [] dwarf;
	static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[9];
		select = new boolean[9];
		
		for(int i=0;i<9;i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==7) {
			findRealDwarf();
			return;
		}
		
		for(int i=start; i<9;i++) {
			if(select[i]) continue;
			
			select[i] = true;
			comb(cnt+1,i+1);
			select[i] = false;
		}
	}
	
	public static void findRealDwarf() {
		int sum = 0;
		for(int i=0;i<9;i++) {
			if(select[i]) {
				sum+=dwarf[i];
				list.add(dwarf[i]);
			}
		}
		
		if(sum==100) {
			Collections.sort(list);
			for(int i=0;i<list.size();i++) sb.append(list.get(i)+"\n");
			
			System.out.println(sb.toString());
			System.exit(0);
		}
		list.clear();
	}

}
