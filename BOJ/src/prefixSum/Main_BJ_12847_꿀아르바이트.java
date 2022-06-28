import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_12847_꿀아르바이트 {
	
	static int n,m;
	static long sum,max=0;
	static int [] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)  arr[i] = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<m-1;i++) sum+=arr[i];
		
		max = sum;

		int index = 0;
		for(int i=m-1; i>=0 && i<arr.length;i++) {
			sum+=arr[i];
			max = Math.max(sum, max);
			sum-=arr[index++];
		}

		System.out.println(max);

	}

}
