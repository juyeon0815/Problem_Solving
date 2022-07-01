package dataStructure;

import java.util.*;

public class Solution_로또의최고순위와최저순위 {
	  public int[] solution(int[] lottos, int[] win_nums) {
	        HashMap<Integer, Boolean> hm = new HashMap<>();
	        HashMap<Integer, Integer> rank = new HashMap<>();
	        
	        rank.put(6,1); 
	        rank.put(5,2); 
	        rank.put(4,3);
	        rank.put(3,4); 
	        rank.put(2,5);
	        
	        for(int i=0;i<win_nums.length;i++) hm.put(win_nums[i],true);
	        
	        int zero = 0, same = 0;
	        for(int i=0;i<lottos.length;i++){
	            int num = lottos[i];
	            
	            if(num==0) zero++;
	            else if(hm.containsKey(num)) same++;
	            
	        }
	        
	        int[] answer = new int[2];
	        
	        answer[0] = rank.get(zero+same)==null?6:rank.get(zero+same);
	        answer[1] = rank.get(same)==null?6:rank.get(same);
	        
	        return answer;
	    }

}
