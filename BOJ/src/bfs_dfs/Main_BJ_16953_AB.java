package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16953_AB {

    static int A,B, answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dfs(A,B,1);
        System.out.println(answer==Integer.MAX_VALUE? -1 : answer);

    }

    public static void dfs(long start, long end, int cnt){
        if(start == end){
            answer = Math.min(answer,cnt);
            return ;
        }

        if(start>end) return;

        dfs(start*2,end,cnt+1);
        dfs((start*10+1),end,cnt+1);
    }
}
