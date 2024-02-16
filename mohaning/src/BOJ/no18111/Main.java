// BOJ 18111번 마인크래프트

package BOJ.no18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 땅의 세로 길이 N, 가로 길이 M, 가지고 있는 블록의 수 B 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// N*M 크기의 배열 생성 후 값 입력
		// 사용할 수 있는 전체 블럭의 수를 계산하여 totalBlock으로 저장
		int totalBlock = B;
		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				totalBlock += map[r][c];
			}
		}

		// 높이를 0 ~ 가능한 최대높이(totalBlock / (N*M))까지 1씩 늘리면서 해당 높이를 맞추는데 걸리는 시간 확인
		// 기존 최소시간보다 짧다면 minTimes, bestHeight 갱신
		int minTimes = Integer.MAX_VALUE;
		int bestHeight = 0;
		for (int height = 0; height <= totalBlock / (N * M); height++) {
			int times = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int diff = map[r][c] - height;
					if (diff >= 0) {
						times += diff * 2;
					} else {
						times += diff * (-1);
					}
				}
			}
			if (times <= minTimes) {
				minTimes = times;
				bestHeight = height;
			}

		}

		// 결과 출력
		System.out.printf("%d %d", minTimes, bestHeight);

	}
}
