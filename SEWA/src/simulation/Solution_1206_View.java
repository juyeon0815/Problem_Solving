import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			
			int count=0;
			
			int N = Integer.parseInt(br.readLine());
			int [] building = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) building[i] = Integer.parseInt(st.nextToken());
			
			for(int i=2;i<N-2;i++) {
				int left = Math.max(building[i-1], building[i-2]);
				int right = Math.max(building[i+1], building[i+2]);
				int mid = building[i];
				
				if(mid>left && mid>right) { //조망권 확보
					count+=mid-Math.max(right, left);
					i+=2;
				}
			}
			sb.append("#"+tc+" "+count+"\n");
		}
		System.out.println(sb.toString());
	}

}
