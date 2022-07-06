package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main_BJ_20291_파일정리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());

		for(int i=0;i<N;i++) {

			String file = br.readLine();
			String [] name = file.split("\\.");
			if(!hm.containsKey(name[1])) hm.put(name[1], 1);
			else hm.put(name[1], hm.get(name[1])+1);
		}
		
		List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i).getKey()+" "+list.get(i).getValue()+"\n");
		}
		
		System.out.println(sb.toString());

	}

}
