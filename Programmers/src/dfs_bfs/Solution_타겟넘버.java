package dfs_bfs;

public class Solution_타겟넘버 {
	static int count = 0;

	public int solution(int[] numbers, int target) {
		boolean[] select = new boolean[numbers.length];
		
		comb(0, numbers.length, select, numbers, target);
		
		return count;
	}

	public static void comb(int cnt, int N, boolean[] select, int[] numbers, int target) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < select.length; i++) {
				int num = numbers[i];
				if (!select[i]) num *= -1;

				sum += num;
			}
			if (sum == target) count++;
			return;
		}

		select[cnt] = true;
		comb(cnt + 1, N, select, numbers, target);
		select[cnt] = false;
		comb(cnt + 1, N, select, numbers, target);
	}

}
