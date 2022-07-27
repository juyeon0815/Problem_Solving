package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_1969_DNA {
	
	static int N,M;
	static int [][] save;
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		save = new int[4][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			list.add(line);
			for(int j=0;j<line.length();j++) {
				switch (line.charAt(j)) {
				case 'A' : save[0][j]++; break;
				case 'C' : save[1][j]++; break;
				case 'G' : save[2][j]++; break;
				case 'T' : save[3][j]++; break;
				}
			}
			
		}
		
		cal();
	}
	
	public static void cal() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int temp=0, idx =0;
			for(int j=0;j<4;j++) {
				if(temp<save[j][i]) {
					temp = save[j][i];
					idx = j;
				}
			}
			
			switch (idx) {
			case 0 : sb.append("A"); break;
			case 1 : sb.append("C"); break;
			case 2 : sb.append("G"); break;
			case 3 : sb.append("T"); break;
			}
		}
		
		String str = sb.toString();
		
		int count =0;
		for(int i=0;i<list.size();i++) {
			String dna = list.get(i);
			
			for(int j=0;j<dna.length();j++) {
				if(dna.charAt(j)!=str.charAt(j)) count++;
			}
		}
		
		System.out.println(str+"\n"+count);
		
	}

}
