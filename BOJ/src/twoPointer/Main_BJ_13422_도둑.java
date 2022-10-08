import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            st  = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[j] = Integer.parseInt(st.nextToken());

            cal();

        }

    }

    public static void cal() {
        int left = 0, right = M, sum=0;

        for(int i=left;i<right; i++) sum+=arr[i];

        int result=0;

        if(N==M) {
            if(sum<K) result++;
        }
        else {
            while(left<N) {

                if(sum<K) result++;
                sum = sum-arr[left]+arr[right];
                left++; right++;
                right = right>N-1? 0 : right;
            }
        }

        System.out.println(result);
    }
}