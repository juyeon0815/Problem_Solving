package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_가장큰수 {

	public String solution(int[] numbers) {
        String [] num = new String[numbers.length];

    for(int i=0;i<numbers.length;i++) num[i] = String.valueOf(numbers[i]);

    Arrays.sort(num, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            return (o2+o1).compareTo(o1+o2);
        }
    });

    String answer ="";
    for(int i=0;i<num.length;i++) answer+=num[i];
    if(answer.charAt(0)=='0') return "0";

    return answer;
	}

}
