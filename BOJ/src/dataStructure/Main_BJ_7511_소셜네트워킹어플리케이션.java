package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_7511_소셜네트워킹어플리케이션 {

    static int [] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T;tc++){
            sb.append("Scenario "+ tc+":"+"\n");

            int num = Integer.parseInt(br.readLine());

            friends = new int[num];

            reset();

            int friendRelationshipNum = Integer.parseInt(br.readLine());
            for(int i=0;i<friendRelationshipNum;i++){
                st = new StringTokenizer(br.readLine());

                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            int findFriends = Integer.parseInt(br.readLine());
            for(int i=0;i<findFriends;i++){
                st = new StringTokenizer(br.readLine());
                //부모가 똑같나 확인
                if(find(Integer.parseInt(st.nextToken()))== find(Integer.parseInt(st.nextToken()))) sb.append(1+"\n");
                else sb.append(0+"\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int find(int a){
        if(friends[a] == a) return a;
        return friends[a] = find(friends[a]);
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot>bRoot) friends[aRoot] = bRoot;
        else friends[bRoot] = aRoot;
    }

    public static void reset(){
        for(int i=0;i<friends.length;i++) friends[i] = i;
    }
}