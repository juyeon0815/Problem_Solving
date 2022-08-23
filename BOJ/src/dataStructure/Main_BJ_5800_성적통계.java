package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_5800_성적통계 {
	
	static int K;
	static int [] score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		for(int i=0;i<K;i++) {
			sb.append("Class "+(i+1)+"\n");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			score = new int[N];
			
			for(int j=0;j<N;j++) {
				score[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(score);
			
			int max=0;
			for(int j=0;j<score.length-1;j++) {
				max = Math.max(max, score[j+1]-score[j]);
			}
			
			sb.append("Max "+ score[score.length-1]+", Min "+score[0]+", Largest gap "+ max+"\n");
			
		}
		System.out.println(sb.toString());

	}

}
