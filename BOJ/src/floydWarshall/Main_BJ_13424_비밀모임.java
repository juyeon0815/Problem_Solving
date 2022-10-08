import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int [][] distance;
    static ArrayList<Integer> people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            distance = new int[N+1][N+1];
            setting();

            for(int j=0;j<M;j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                distance[start][end] = distance[end][start] = value;
            }

            floyd();

            people = new ArrayList<>();
            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++) people.add(Integer.parseInt(st.nextToken()));

            sb.append(cal()+"\n");
        }

        System.out.println(sb.toString());

    }

    public static void setting() {
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i==j) continue;
                distance[i][j] = 1000001;
            }
        }
    }

    public static void floyd() {

        // 경 -> 출 -> 도
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {

                for(int k=1;k<=N;k++) {
                    if(j==k) continue;

                    if(distance[j][k]> distance[j][i] + distance[i][k]) distance[j][k] = distance[j][i] + distance[i][k];
                }
            }
        }
    }

    public static int cal() {

        int result = Integer.MAX_VALUE;
        int index=1;
        for(int i=1;i<=N;i++) {
            int sum=0;
            for(int j=0;j<people.size();j++) {
                sum+=distance[people.get(j)][i];
            }

            if(result>sum) {
                result = sum;
                index = i;
            }
        }
        return index;
    }
}