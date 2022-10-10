import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    static class info {
        int startX, startY, endX, endY;

        public info(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static class position {
        int x, y , cnt, index;

        public position(int x, int y, int cnt, int index) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.index = index;
        }
    }

    static int N,M,K, startX, startY;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [][] visited;
    static HashMap<Integer, info> hm = new HashMap<>();
    static ArrayList<position> guestInfo = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken())-1;
        startY = Integer.parseInt(st.nextToken())-1;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            hm.put(i, new info(x1,y1,x2,y2));
        }

        solution();
        System.out.println(K);
    }

    public static void solution() {
        for(int i=0;i<M;i++) {
            guestInfo.clear();
            findGuest(); //손님 - 택시
        }
    }

    public static boolean isSamePosition() {
        for(Map.Entry<Integer, info> item : hm.entrySet()){
            if(item.getValue().startY==startY && item.getValue().startX==startX) {
                guestInfo.add(new position(startX, startY,0, item.getKey()));
                return true;
            }
        }
        return false;
    }

    public static void findGuest() {
        boolean flag = isSamePosition();

        if(!flag) {
            for(Map.Entry<Integer, info> item : hm.entrySet()){
                bfs(new position(item.getValue().startX, item.getValue().startY,0, item.getKey()));
            }
        }

        Collections.sort(guestInfo, new Comparator<position>() {
            @Override
            public int compare(position o1, position o2) {
                if(o1.cnt == o2.cnt) {
                    if(o1.x==o2.x)
                        return o1.y-o2.y;
                    return o1.x-o2.x;
                }
                return o1.cnt-o2.cnt;
            }
        });

        endCondition();

        K-=guestInfo.get(0).cnt;

        // 손님 - 목적지
        startX = hm.get(guestInfo.get(0).index).endX;
        startY = hm.get(guestInfo.get(0).index).endY;

        int x = guestInfo.get(0).x;
        int y = guestInfo.get(0).y;
        int index = guestInfo.get(0).index;

        guestInfo.clear();
        bfs(new position(x,y ,0,index));

        endCondition();

        K-=guestInfo.get(0).cnt;
        K+=guestInfo.get(0).cnt*2;

        hm.remove(index);

    }

    public static void endCondition() {
        if(guestInfo.isEmpty()|| K-guestInfo.get(0).cnt<0) {
            System.out.println(-1);
            exit(0);
        }
    }

    public static void bfs(position temp) {
        Queue<position> queue = new LinkedList<>();
        visited = new boolean[N][N];

        queue.add(new position(temp.x, temp.y,0, temp.index));

        while(!queue.isEmpty()) {
            position item = queue.poll();

            if(item.x == startX && item.y==startY) {
                guestInfo.add(new position(temp.x, temp.y, item.cnt, item.index));
                return;
            }

            for(int i=0;i<4;i++) {
                int nx = item.x + dx[i];
                int ny = item.y + dy[i];

                if(!range(nx,ny)|| visited[nx][ny] || map[nx][ny]==1) continue;

                visited[nx][ny] = true;
                queue.add(new position(nx,ny, item.cnt+1, item.index));

            }
        }
    }
    public static boolean range(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}