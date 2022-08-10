package dataStructure;

import java.util.*;

class Solution {
    
    static class info {
		String state, id;

		public info(String state, String id) {
			this.state = state;
			this.id = id;
		}
	}
	
	static HashMap<String, String> hm = new HashMap<>(); // ID, NAME
	static List<info> list = new ArrayList<>(); // STATE, ID
    static String [] answer;
    
    public String[] solution(String[] record) {
        
        for(int i=0;i<record.length;i++){
            String[] line = record[i].split("\\s");
            
            String state = line[0];
            String id = line[1];
            
            if(!state.equals("Change")) list.add(new info(state,id));
            
            if(state.equals("Enter") || state.equals("Change")){
                String name = line[2];
                hm.put(id,name);
            }
        }
        print();
        return answer;
    }
    
    public static void print() {
        answer = new String[list.size()];
        int index=0;
        for(int i=0;i<list.size();i++){
            String name = hm.get(list.get(i).id);
            if(list.get(i).state.equals("Enter")){
                answer[index++] = name+"님이 들어왔습니다.";
            }else answer[index++] = name+"님이 나갔습니다.";
        }
    }
}