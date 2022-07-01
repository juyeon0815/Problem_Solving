package simulation;

public class Solution_행렬테두리회전하기 {
	  static int [][] map;
	    public int[] solution(int rows, int columns, int[][] queries) {
	        int[] answer = new int[queries.length];
	        map = new int[rows][columns];
	        
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++) map[i][j] = ((i)*columns + j+1);
	        }
	        
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++) System.out.print(map[i][j] +" ");
	             System.out.println();
	        }
	        
	        for(int i=0;i<queries.length;i++){
	            answer[i] = rotate(queries[i]);
	        }
	        
	        return answer;
	    }
	    public static int rotate(int [] range){
	        int x1 = range[0]-1;
	        int y1 = range[1]-1;
	        int x2 = range[2]-1;
	        int y2 = range[3]-1;
	        
	        int temp = map[x1][y1];
	        int min = temp;
	        //위로
	        for(int x=x1+1; x<=x2; x++){
	            map[x-1][y1] = map[x][y1];
	            min = Math.min(min,map[x][y1]);
	        }
	        
	        //왼쪽으로
	        for(int y=y1+1; y<=y2; y++){
	            map[x2][y-1] = map[x2][y];
	            min = Math.min(min,map[x2][y]);
	        }
	        
	        //아래로
	        for(int x=x2-1; x>=x1; x--){
	            map[x+1][y2] = map[x][y2];
	            min = Math.min(min,map[x][y2]);
	        }
	        
	        //오른쪽으로
	        for(int y=y2-1; y>=y1; y--){
	            map[x1][y+1] = map[x1][y];
	            min = Math.min(min,map[x1][y]);
	        }
	        
	        map[x1][y1+1] = temp;
	        return min;
	    }

}
