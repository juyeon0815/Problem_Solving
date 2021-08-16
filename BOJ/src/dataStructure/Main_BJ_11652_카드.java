package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;

public class Main_BJ_11652_카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Long, Integer> hm = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			Long num = Long.parseLong(br.readLine());
			
			if(hm.containsKey(num)) hm.put(num, hm.get(num)+1);
			else hm.put(num, 1);
		}
		
		List<Entry<Long, Integer>> list_entries = new ArrayList<Entry<Long, Integer>>(hm.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<Long, Integer>>() {
			@Override
			public int compare(Entry<Long, Integer> o1, Entry<Long, Integer> o2) {
				if(Objects.equals(o1.getValue(), o2.getValue())) return o1.getKey().compareTo(o2.getKey());
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		System.out.println(list_entries.get(0).getKey());
	}

}
