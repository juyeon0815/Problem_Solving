package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1202_보석도둑 {

    static class Jewelry implements Comparable<Jewelry> {
        int weight, value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewelry o) {
            return (this.weight-o.weight);
        }
    }

    static int N,K;
    static boolean [] visited;
    static ArrayList<Jewelry> jewelries = new ArrayList<>();
    static ArrayList<Integer> bag = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new boolean[K];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            int wei = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            jewelries.add(new Jewelry(wei,val));
        }

        for(int i=0;i<K;i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bag);
        Collections.sort(jewelries);

        cal();
  }

    public static void cal() {
        Queue<Integer> queue = new PriorityQueue<>((o1,o2) -> (o2-o1));
        
        long sum=0;
        int cnt=0;
        
        for(int i=0;i<K;i++) {
        	while(true) {
        		if(cnt>=N) break;
        		
        		Jewelry item = jewelries.get(cnt);
        		
        		if(bag.get(i)<item.weight) break;
        		
        		queue.add(item.value);
        		cnt++;
        	}
        	
        	if(!queue.isEmpty()) sum+= Math.abs(queue.poll());
        }
        
        System.out.println(sum);
    }
}
