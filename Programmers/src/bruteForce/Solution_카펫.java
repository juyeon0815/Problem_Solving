package bruteForce;

import java.util.ArrayList;

public class Solution_카펫 {

	public int[] solution(int brown, int yellow) {
        ArrayList<int []> list = new ArrayList<>();
		//소인수분해
		for(int i=brown+yellow; i>0;i--) {
			if((brown+yellow)%i==0) {
				list.add(new int[] {i,(brown+yellow)/i});
			}
		}
		int [] answer = new int[2];
		for(int i=0;i<list.size();i++) {
			int width = list.get(i)[0];
			int height = list.get(i)[1];
			
			if(width>=height) {
				//테두리를 브라운으로 다 채울 수 있나
				int num = width*2 + (height-2)*2;
				if(brown>=num) {
					answer[0] = width;
					answer[1] = height;
					break;
				}
			}
		}
        return answer;
    }

}
