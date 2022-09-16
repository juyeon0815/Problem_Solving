import java.util.*;

class Solution {
    
    static HashMap<Integer, ArrayList<Integer>> car = new HashMap<>();
    static Map<Integer, Integer> result = new TreeMap<>();
    static int [] answer;
    
    public int[] solution(int[] fees, String[] records) {
        save(records);
        cal();
        money(fees);
        return answer;
    }
    
    public static void save(String[] records) {
        StringTokenizer st;
        ArrayList<Integer> list;
        
        for(int i=0;i<records.length;i++) {
            st = new StringTokenizer(records[i]);
            list = new ArrayList<>();
            String [] time = st.nextToken().split(":");
            int carNumber = Integer.parseInt(st.nextToken());
            String behavior = st.nextToken();
            int times = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            
            if(car.containsKey(carNumber)) {
                list = car.get(carNumber);   
            }
            list.add(times);
            car.put(carNumber,list);
        }
    }
    
    public static void cal(){
        ArrayList<Integer> list = new ArrayList<>();
        int endTime = 1439;

        boolean end = false;
        for(Integer key : car.keySet()) {
            list.clear();
            if(car.get(key).size()%2!=0) {
                list = car.get(key);
                list.add(endTime);
                car.put(key, list);
            }

            int time = 0;
            for(int j=0;j<car.get(key).size()/2;j++) {
                time+= car.get(key).get(j*2+1)-car.get(key).get(j*2);
            }
            result.put(key, time);
        }
    }
    
    public static void money(int[] fees) {
        for(Integer key : result.keySet()) {
            if(result.get(key)>fees[0]) {
                int time = result.get(key)-fees[0];
                int men = fees[1];
                
                if(time%fees[2]!=0) time = time/fees[2]+1;
                else time/=fees[2];
                men+= time*fees[3];
                
                result.put(key,men);
                
            }else result.put(key,fees[1]);
        }
        
        answer = new int[result.size()];
        int index=0;
        
        for(Integer ans : result.keySet()){
            answer[index++] = result.get(ans);
        }
        
    }
}