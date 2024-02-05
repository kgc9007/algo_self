// BOJ 11652번 카드

package BOJ.no11652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Map<Long, Integer> map = new HashMap<>();
		List<Long> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			long num = sc.nextLong();
			if (map.containsKey(num)) {
				int count = map.get(num);
				count++;
				map.put(num, count);
			} else {
				map.put(num, 1);
				list.add(num);
			}
		}

		int maxCnt = 0;
		long result = Long.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i)) >= maxCnt && list.get(i) < result) {
				result = list.get(i);
				maxCnt = map.get(list.get(i));
			}
		}

		System.out.println(result);

	}

}
