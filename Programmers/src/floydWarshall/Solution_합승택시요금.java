class Solution {
    
    static int [][] distance;
    static int INF = 999999;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // n : 노드 수, s : 출발지, a : 위치1, b : 위치2 
        setting(n, fares);
        floyd(n);
        int answer = cal(n,s,a,b);
        return answer;
    }
    
    public static void setting(int n, int[][] fares) {
        distance = new int[n+1][n+1];
        
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(i==j) continue;
                distance[i][j] = INF;
            }
        }
        
        for(int i=0;i<fares.length;i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int value = fares[i][2];
            
            distance[start][end] = distance[end][start] = value;
        }   
    }
    
    public static void floyd(int n) {
        
        //경출도
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(i==j) continue;
                for(int k=1;k<n+1;k++){
                    if(distance[j][k]>distance[j][i] + distance[i][k])
                        distance[j][k] = distance[j][i] + distance[i][k];
                }
            }
        }        
    }
    
    public static int cal(int n,int start, int a, int b) {
        int isolation = distance[start][a] + distance[start][b];
        
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n+1;i++) {
            int dis = distance[start][i] + distance[i][a] + distance[i][b];
            
            if(dis<min) min = dis;
        }
        return min;
    } 
    
    public static void print() {
        for(int i=1;i<distance.length;i++) {
            for(int j=1;j<distance[i].length;j++) {
                System.out.print(distance[i][j] +" ");
            }
            System.out.println();
        }
    }
}