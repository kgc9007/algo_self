// BOJ 1764번 듣보잡
// https://www.acmicpc.net/problem/1764

package BOJ.no1764;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 듣도 못한 놈 N 명
		int N = sc.nextInt();
		// 보도 못한 놈 M 명
		int M = sc.nextInt();

		// 듣도 못한 놈, 보도 못한 놈 모두 한 배열에 저장
		String[] arr = new String[N + M];
		for (int i = 0; i < N + M; i++) {
			arr[i] = sc.next();
		}

		// 정렬 실시
		Arrays.sort(arr);

		// 듣도 보도 못한 놈을 저장할 리스트 (결과)
		List<String> result = new ArrayList<>();
		
		// 연속으로 똑같은 이름이 두 번 나오면
		// -> 듣도 보도 못한 놈!, i++ 로 배열의 다음 값 확인
		// 마지막 사람은 확인 X (배열 범위 초과 방지)
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].equals(arr[i + 1])) {
				result.add(arr[i]);
				i++;
			}
		}
		
		// 결과 출력
		System.out.println(result.size());
		for (int i = 0 ; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}
}
