// BOJ 20922번 겹치는 건 싫어
// https://www.acmicpc.net/problem/20922

package BOJ.no20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 스캐너로 풀이시 시간초과 -> BufferReader로 수정
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

//		int N = sc.nextInt();
//		int K = sc.nextInt();
		int N = Integer.parseInt(st.nextToken()); // 수열의 길이 N
		int K = Integer.parseInt(st.nextToken()); // 똑같은 숫자의 최대 개수 K

		// 전체 수열 입력
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 숫자(원소) - 숫자의 개수 를 저장할 맵 생성
		Map<Integer, Integer> map = new HashMap<>();

		// 최장 연속 부분 수열의 길이 0으로 초기화
		int maxLength = 0;

		// [투포인터]
		// 1. 오른쪽 포인터의 숫자를 부분수열에 추가하며 뒤로 이동
		// 2-1. 만약 해당 숫자가 아직 한번도 부분수열에 포함되지 않았다면
		// -> 맵에 추가 (num, 1) : 해당 숫자가 한 번 수열에 들어감을 의미
		// 2-2. 만약 해당 숫자가 이미 부분수열에 포함된 적이 있다면
		// -> 맵에서 들어간 횟수를 확인 후 K보다 크다면
		// 왼쪽 포인터를 오른쪽으로 이동시키며 K보다 작아질때까지 반복
		// 왼쪽 포인터를 이동시킬때마다 부분수열에서 벗어나는 원소 정보를 map에서 갱신
		// 3. 부분수열의 길이 확인, 기존 최대길이와 비교 후 갱신
		// 4. 오른쪽 포인터가 마지막에 도달할때까지 반복
		int left = 0;
		int right = 0;

		while (right < N) {
			int num = arr[right++];

			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);

				while (map.get(num) > K) {
					int leftNum = arr[left];
					map.put(leftNum, map.get(leftNum) - 1);
					left++;
				}
			}
			maxLength = Math.max(maxLength, right - left);

//			System.out.println("left : " + left + " right : " + right);
		}

		// 결과 출력
		System.out.println(maxLength);
	}
}
