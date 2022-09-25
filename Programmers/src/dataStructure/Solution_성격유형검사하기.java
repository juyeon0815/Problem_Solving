import java.util.*;
import java.util.Map.*;

class Solution {
    
    static HashMap<Integer, Integer> score = new HashMap<>();
    static HashMap<Integer, ArrayList<Character>> surveyInfo = new HashMap<>();
    static HashMap<Integer, ArrayList<Character>> personality = new HashMap<>();
    static HashMap<Character, Integer> kindInfo = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        setting(survey);
        String answer =sol(choices);
        return answer;
    }
    
    public static void setting(String[] survey) {
        
        int sco = 3;
        for(int i=1;i<=7;i++) {
            if(i<4)
                score.put(i,sco--);
            else
                score.put(i,sco++);
        }
        
        kindInfo.put('R',0); kindInfo.put('T',0);
        kindInfo.put('C',0); kindInfo.put('F',0);
        kindInfo.put('J',0); kindInfo.put('M',0);
        kindInfo.put('A',0); kindInfo.put('N',0);
        
        personality.put(1,new ArrayList<>(Arrays.asList('R', 'T')));
        personality.put(2,new ArrayList<>(Arrays.asList('C', 'F')));
        personality.put(3,new ArrayList<>(Arrays.asList('J', 'M')));
        personality.put(4,new ArrayList<>(Arrays.asList('A', 'N')));
        
        ArrayList<Character> list;
        
        for(int i=0; i<survey.length;i++) {
            String line = survey[i];
            
            list = new ArrayList<>();
            for(int j=0;j<line.length();j++) {
                list.add(line.charAt(j));
            }
            surveyInfo.put(i+1, list);
        }
        
    }
    
    public static String sol(int[] choices) {
        ArrayList<Character> list;
        
        for(int i=0;i<choices.length; i++) {
            int num = score.get(choices[i]);
            
            list = surveyInfo.get(i+1);
            
            int index = choices[i]<4 ? 0 : 1;
            
            kindInfo.put(list.get(index), kindInfo.get(list.get(index))+num);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=4;i++) {
            list = personality.get(i);
            
            int num1 = kindInfo.get(list.get(0));
            int num2 = kindInfo.get(list.get(1));
            
            if(num1==num2) 
                sb.append(list.get(0)>list.get(1)? list.get(1) : list.get(0));
            else
                sb.append(num1>num2? list.get(0) : list.get(1));
            
        }
        return sb.toString();
    }
    
    
}