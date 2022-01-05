package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1026_보물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<Integer> A, B;
		
		int N = Integer.parseInt(br.readLine());
		
		A = new ArrayList<>();
		B = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) A.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) B.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(A,Collections.reverseOrder());
		Collections.sort(B);
		
		
		int sum=0;
		
		for(int i=0;i<N;i++) sum+=A.get(i)*B.get(i);
		
		System.out.println(sum);

	}

}
