package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1138_한줄로서기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [] line = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int count=0;
		for(int i=1;i<=N;i++) {
			int number = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<N;j++) {
				
				if(count==number && line[j]==0) {
					line[j] = i;
					break;
				}
				
				if(line[j]==0) count++;
				
			}
			count=0;
		}		
		for(int i=0;i<N;i++) System.out.print(line[i]+" ");
	}

}
