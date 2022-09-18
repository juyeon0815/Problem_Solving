class Solution {
    
    static int[] selected, ryan, apeachReverse, result, answer;
    static int max=0;
    
    public int[] solution(int n, int[] info) {
        
        apeachReverse = new int[11]; //어피치
        selected = new int[n]; // 라이언 쏜 배열
        result = new int[11]; // 결과 뒤집기 전
        
        reserve(apeachReverse, info);
        comb(n,0,0,info);
        System.out.println(max);
        
        if(max==0) {
            answer = new int[1];
            answer[0] = -1;
        }else {
            answer = new int[11];
            reserve(answer, result);
        }
        return answer;
    }
    
    public static void reserve(int[] arr, int[] arr1) {
        
        for (int i = arr1.length - 1, j = 0; i >= 0; i--, j++) {            
            arr[j] = arr1[i];        
        }
    }
    
    public static void comb(int n, int cnt, int start, int[] info) {
        if(cnt==n) {
            cal(info);
            return;
        }
        
        for(int i=start;i<=10;i++) {
            selected[cnt] = i;
            comb(n,cnt+1, i,info);
        }
    }
    
    public static void cal(int[] info) {
       ryan = new int[11];
       
       for(int i=0;i<selected.length;i++) {
           ryan[selected[i]]++;
       } 
        
       int ryanCount=0, apeachCount=0, diff=0;
       for(int i=0;i<11; i++) {
           if(ryan[i]>apeachReverse[i]) ryanCount+=i;
           else if(ryan[i]<=apeachReverse[i]) 
               if(apeachReverse[i]!=0)
               apeachCount+=i;
       } 
       
       if(ryanCount>apeachCount) {
           diff = ryanCount-apeachCount;
           
           if(max<diff) {
               max = diff;
               result = ryan.clone();
           }else if(max==diff) {
               
               for(int i=0;i<11;i++) {
                   if(result[i]>ryan[i]) break;
                   else if(result[i]<ryan[i]) {
                       result = ryan.clone();
                       break;
                   }
               }
           }
           
       } 
        
    }
}