package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution_베스트앨범 {
	
	static class info{
		int plays, idx;

		public info(int plays, int idx) {
			super();
			this.plays = plays;
			this.idx = idx;
		}
		
	}

	public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<genres.length;i++) {
			if(map.containsKey(genres[i])) {
				map.put(genres[i], map.get(genres[i])+plays[i]);
			}
			else map.put(genres[i], plays[i]);
		}
		
		ArrayList<String> gen = new ArrayList<>(map.keySet());
		Collections.sort(gen, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (map.get(o1)-map.get(o2))*-1;
			}
		}); //장르 sort
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=0;i<gen.size();i++) {
			ArrayList<info> music = new ArrayList<>();
			for(int j=0;j<genres.length;j++) {
				if(genres[j].equals(gen.get(i))) {
					music.add(new info(plays[j],j));
				}
			}
			Collections.sort(music, new Comparator<info>() {
				@Override
				public int compare(info o1, info o2) {
					return (o1.plays-o2.plays)*-1;
				}
			});
			
			if(music.size()<2) ans.add(music.get(0).idx);
			else {
				for(int k=0; k<2;k++) ans.add(music.get(k).idx);
			}
		}
		
		int[] answer = new int[ans.size()];
		for(int i=0;i<ans.size();i++) answer[i] = ans.get(i);
        return answer;
    }

}
