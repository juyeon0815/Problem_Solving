import java.util.*;

class Solution {
    
    static Queue<Integer> que1, que2;
    static long sumQue1, sumQue2;
    
    public int solution(int[] queue1, int[] queue2) {
        long sum = input(queue1, queue2);
        int answer = sol(sum);
        return answer;
    }
    
    public static long input(int[] queue1, int[] queue2) {  
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
        
        for(int i=0; i<queue1.length;i++) {
            que1.add(queue1[i]);
            sumQue1+=queue1[i];
            
            que2.add(queue2[i]);
            sumQue2+=queue2[i];
            
        }
        
        return sumQue1+sumQue2;
    }
    
    public static int sol(long sum) {
        if (sum%2==1) return -1;
        long value = sum/2;
        
        int p1 = 0, p2 = 0, limit=que1.size()*2;
        while(p1<=limit && p2<=limit) {
            if(sumQue1==value) return p1+p2;
            
            if(sumQue1>value) {
                int tmp = que1.poll();
                que2.add(tmp);
                sumQue1-=tmp;
                sumQue2+=tmp;
                p1++;
                
            }else {
                int tmp = que2.poll();
                que1.add(tmp);
                sumQue2-=tmp;
                sumQue1+=tmp;
                p2++;
            }   
        }
        return -1;
    }
}