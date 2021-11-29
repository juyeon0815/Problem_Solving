import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Character> list = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); //N개의 숫자
			int K = Integer.parseInt(st.nextToken()); //K번째로 큰 수
			
			int side = N/4;

			String line = br.readLine();
			for(int i=0;i<N;i++) {
				list.add(line.charAt(i));
			}
			
			
			for(int i=0;i<side;i++) {
				for(int j=0;j<list.size();j++) {
					sb.append(list.get(j));
					if((j+1)%side==0) {
						hs.add(sb.toString());
						sb.setLength(0);
					}
				}
				list.add(0,list.get(list.size()-1));
				list.remove(list.size()-1);
			}
			
			List<String> sort = new ArrayList<>(hs); 
			Collections.sort(sort,Collections.reverseOrder());
			
			result.append("#"+t+" "+Integer.parseInt(sort.get(K-1),16)+"\n");
			
			hs.clear();
			list.clear();
		}
		System.out.println(result.toString());

	}

}
