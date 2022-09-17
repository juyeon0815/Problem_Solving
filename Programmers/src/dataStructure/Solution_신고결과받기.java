import java.util.*;

class Solution {
    
    static HashMap<String, Set<String>> reportInfo = new HashMap<>();
    static HashMap<String, Integer> userInfo = new LinkedHashMap<>();
    static HashMap<String, Integer> mail = new LinkedHashMap<>();
    static Set<String> stop = new HashSet<>();
    
    public int[] solution(String[] id_list, String[] report, int k) {
        input(id_list);
        report(report);
        int[] answer = cal(k);
        return answer;
    }
    
    public static void input(String[] id_list) {
        for(int i=0;i<id_list.length;i++) {
            userInfo.put(id_list[i],0);
            mail.put(id_list[i],0);
        }
    }
    
    public static void report(String[] report) {
        StringTokenizer st;
        Set<String> userList;
        
        for(int i=0;i<report.length;i++){
            st = new StringTokenizer(report[i]);
            userList = new HashSet<>();
            String user = st.nextToken();
            String user2 = st.nextToken();
            
            if(reportInfo.containsKey(user)) {
                userList = reportInfo.get(user);
                userList.add(user2);
                reportInfo.put(user,userList);
            } else {
                userList.add(user2);
                reportInfo.put(user,userList);
            }
        }
    }
    
    public static int[] cal(int k) {
        for(String key : reportInfo.keySet()) {
             
            for(String name : reportInfo.get(key)) {
                userInfo.put(name, userInfo.get(name)+1);
            }
        }
        
        for(String key : userInfo.keySet()) {
            if(userInfo.get(key)>=k) stop.add(key);
        }
        
        int count=0;
        for(String key : reportInfo.keySet()) {
            count=0;
            for(String name : reportInfo.get(key)) {
                if(stop.contains(name)) count++;
            }
            mail.put(key,count);
        }
        
        int [] ans = new int[mail.size()];
        int index=0;
        for(String key : mail.keySet()) {
            ans[index++] = mail.get(key);
        }
        
        return ans;
    }
}