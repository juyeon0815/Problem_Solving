import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        
        String ch = change(n,k);
        answer = split(ch);
        
        return answer;
    }
    
    public static String change(int n, int k) {
        String ans = "";
        
        while(n>0){
            ans = (n%k) + ans;
            n/=k;
        }
        
        return ans;
    }
    
    public static int split(String num) {
        StringTokenizer st = new StringTokenizer(num, "0");
        
        int size = st.countTokens();

        int count=0;
        for(int i=0;i<size;i++ ){
            if(isMinority(st.nextToken())) count++;
        }  
        return count;
    }
    
    public static boolean isMinority(String check) {
        Long num = Long.parseLong(check);
        
        if(num==1) return false;
        else if(num==2) return true;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        
        return true;
        
    }
}