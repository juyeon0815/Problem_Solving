import java.util.Stack;

public class Solution_크레인인형뽑기게임 {
	
	public static void main(String[] args) {
		
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		
		Stack<Integer> stack = new Stack<>();
		
		int answer=0;
		for(int i=0;i<moves.length;i++) {
			int pop = moves[i]-1;
			
			loop :
			for(int j=0;j<board.length;j++) {
				if(board[j][pop]!=0) {
					if(!stack.isEmpty()) {
						if(stack.peek()==board[j][pop]) {
							stack.pop();
							answer+=2;
						}else stack.add(board[j][pop]);
					}
					else {
						stack.add(board[j][pop]);
					}
					board[j][pop] = 0;
					break loop;
				}
			}
		}
		
		System.out.println(answer);

	}
}
