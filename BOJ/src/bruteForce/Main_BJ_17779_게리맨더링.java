package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17779_게리맨더링 {
	
	static int N, answer=Integer.MAX_VALUE;
	static int [] people;
	static boolean [] isSelected;
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		people = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) people[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				int index = Integer.parseInt(st.nextToken());
				
				list[i].add(index);
			}
		}
		
		//둘로 나누기
		for(int i=1;i<=N/2;i++) {
			isSelected = new boolean[N+1];
			comb(0,1,i);
		}
		
		System.out.println(answer==Integer.MAX_VALUE?-1 : answer);

	}
	
	public static void comb(int cnt, int start, int select) {
		if(cnt == select) {
			//각 선거구끼리 연결되어 있는지 확인
			isConnected();
			return;
		}
		
		for(int i=start;i<people.length;i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			comb(cnt+1,i+1,select);
			isSelected[i] = false;
		}
	}
	
	public static void isConnected() {
		//1번 선거구 연결 확인
		boolean [] connect = new boolean[N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		
		int areaA = 0, areaB=0;
		for(int i=1;i<isSelected.length;i++) {
			if(isSelected[i]) {
				areaA = i;
				break;
			}
		}
		
		for(int i=1;i<isSelected.length;i++) {
			if(!isSelected[i]) {
				areaB = i;
				break;
			}
		}
		
		
		queue.add(areaA);
		connect[areaA] = true;
		while(!queue.isEmpty()) {
			
			int item = queue.poll();
			
			for(int temp : list[item]) {
				if(connect[temp] || !isSelected[temp]) continue;
				
				queue.add(temp);
				connect[temp] = true;
			}
		}
		
		queue.add(areaB);
		connect[areaB] = true;
		while(!queue.isEmpty()) {
			
			int item = queue.poll();
			
			for(int temp : list[item]) {
				if(connect[temp] || isSelected[temp]) continue;
				
				queue.add(temp);
				connect[temp] = true;
			}
		}
		
		boolean flag = true;
		for(int i=1;i<connect.length;i++) {
			if(!connect[i]) {
				flag = false;
				break;
			}
		}
		
		// 연결되어 있다면 인구수 체크
		int sumA=0, sumB=0;
		if(flag) {
			for(int i=1;i<isSelected.length;i++) {
				if(isSelected[i]) sumA+=people[i];
				else sumB+=people[i];
			}
			
			int minus = Math.abs(sumA-sumB);
			answer = Math.min(answer, minus);
		}
	}

}
