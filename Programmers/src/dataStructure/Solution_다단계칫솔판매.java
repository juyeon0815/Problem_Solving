package dataStructure;

import java.util.*;
import java.util.Map.Entry;

public class Solution_다단계칫솔판매 {

	 static HashMap<String, String> relationship = new HashMap<>();
	    static HashMap<String, Integer> result = new LinkedHashMap<>();
	    
	    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
	        
	        
	        for(int i=0;i<enroll.length;i++) {
	            result.put(enroll[i],0);
	            relationship.put(enroll[i], referral[i]);
	        }
	        
	        cal(seller, amount);
	        int[] answer = new int [result.size()];
	        int index =0;
	        for(Entry<String, Integer> item : result.entrySet()){
	            answer[index++] = item.getValue();
	        }
	        return answer;
	    }
	    
	    public static void cal(String[] seller, int[] amount){
	        
	        for(int i=0;i<seller.length;i++){
	            String name = seller[i];
	            int price = amount[i] * 100;
	            
	            int profit = (int)(price*0.1);
	            
	             while(profit>0 && !name.equals("-")){
	                profit = (int)(price*0.1);
	                price-=profit;
	                
	                result.put(name, result.get(name)+price);
	                price = profit;
	                if(price<=0) break;
	                name = relationship.get(name);      
	            }
	        }

	    }

}
