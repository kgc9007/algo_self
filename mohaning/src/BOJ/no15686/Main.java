// BOJ 13686번 치킨 배달
// https://www.acmicpc.net/problem/15686

package BOJ.no15686;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	// 도시의 크기 N
	// 남길 수 있는 치킨집의 최대 개수 M
	// 도시의 각 칸의 정보를 저장할 배열 map
	// map[r][c] = 0 : 빈칸, 1: 집, 2 : 치킨집
	static int N;
	static int M;
	static int[][] map;

	// 집의 위치들을 저장할 리스트 house
	// 치킨집의 위치들을 저장할 리스트 house
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	
	// 각 치킨집의 폐업 여부를 저장할 배열 isRemained
	// true -> 폐업 X, false -> 폐업
	static boolean[] isRemained;
	
	// 도시의 치킨거리(모든 집의 치킨 거리의 합) 초기화
	static int minSumOfDistance = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				// 해당 구역에 집이 있으면 house에 추가
				if (map[r][c] == 1) {
					house.add(new int[] { r, c });
				}
				
				// 해당 구역에 치킨집이 있으면 chicken에 추가
				else if (map[r][c] == 2) {
					chicken.add(new int[] { r, c });
				}
			}
		}

		// isRemained 초기화 후 solve 실행
		isRemained = new boolean[chicken.size()];
		solve(0, 0);

		// 결과 출력
		System.out.println(minSumOfDistance);

	}

	public static void solve(int idx, int count) {
		// 남겨둘 M 개의 치킨집을 선정했다면 치킨거리의 합 계산
		if (count == M) {
			// sum = 0으로 초기화
			int sum = 0;
			
			// 각각의 집의 최소 치킨거리 계산
			// j번째 치킨집이 남아있다면 거리 계산
			// minDistance보다 작다면 갱신
			for (int i = 0; i < house.size(); i++) {
				int minDistance = Integer.MAX_VALUE;
				for (int j = 0; j < isRemained.length; j++) {
					if (isRemained[j]) {
						int distanceR = Math.abs(house.get(i)[0] - chicken.get(j)[0]);
						int distanceC = Math.abs(house.get(i)[1] - chicken.get(j)[1]);
						minDistance = Math.min(minDistance, distanceR + distanceC);
					}
				}
				// 해당 집의 최소 치킨거리를 sum에 추가
				sum += minDistance;

				// 기존 최소값을 갱신할 수 없다면 조기에 종료 (백트래킹)
				if (sum >= minSumOfDistance) {
					return;
				}
			}
			
			// 도시의 치킨거리 갱신
			minSumOfDistance = Math.min(minSumOfDistance, sum);
			return;
		}

		// 모든 치킨집에 대해 폐업할지 아닐지를 결정했다면 종료
		if (idx == isRemained.length) {
			return;
		}

		// 해당 치킨집 유지
		isRemained[idx] = true;
		solve(idx + 1, count + 1);

		// 해당 치킨집 폐업
		isRemained[idx] = false;
		solve(idx + 1, count);
	}
}
