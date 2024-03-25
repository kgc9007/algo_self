// BOJ 21608번 상어 초등학교
// https://www.acmicpc.net/problem/21608

package BOJ.no21608;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	// 교실의 크기 N
	static int N;
	static int[][] map;

	// 각 학생이 좋아하는 학생의 정보를 저장할 리스트
	// 자리를 정하는 순서대로 입력
	// arr[0] : 해당 순서의 학생 번호
	// arr[1] ~ arr[4] : 해당 학생이 좋아하는 학생의 번호
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 교실의 크기 N 입력
		N = sc.nextInt();
		map = new int[N][N];

		// 자리 배정 순서대로
		// 각 학생들이 좋아하는 학생 4명씩 배열로 만들어서 리스트에 입력
		for (int i = 0; i < N * N; i++) {
			int[] arr = new int[5];
			for (int j = 0; j < 5; j++) {
				arr[j] = sc.nextInt();
			}
			list.add(arr);
		}

		// 자리 배정
		for (int idx = 0; idx < N * N; idx++) {
			getSeat(idx);
		}

		// 점수 계산 후 결과 출력
		System.out.println(getScore());

	}

	// 학생의 자리 배정
	public static void getSeat(int idx) {
		// 주변의 좋아하는 학생 수의 최대값, 빈 칸의 수의 최대값 0으로 초기화
		int maxLike = 0;
		int maxBlank = 0;
		// 그 때의 자리를 bestR, bestC로 저장, -1로 초기화
		int bestR = -1;
		int bestC = -1;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 해당 칸이 빈칸이면 주변의 좋아하는 학생 수, 빈 칸의 수 확인
				if (map[r][c] == 0) {
					int countLike = 0;
					int countBlank = 0;
					// 사방탐색
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						// 해당 위치가 경계를 벗어나지 않았을때만 확인
						if (isNotOut(nr, nc)) {
							// 빈 칸이면 countBlank++ 후 다음 주변 칸으로
							if (map[nr][nc] == 0) {
								countBlank++;
								continue;
							}
							// 빈 칸이 아니라면 좋아하는 학생 리스트에 있는지 확인
							for (int i = 1; i < 5; i++) {
								// 좋아하는 학생 중 한명이라면 countLike++ 후 다음 칸으로
								if (map[nr][nc] == list.get(idx)[i]) {
									countLike++;
									break;
								}
							}
						}
					}
					// 주변 4칸을 모두 확인한 후
					// 기존의 maxLike보다 크다면 
					// maxLike, maxBlank, bestR, bestC 갱신
					if (countLike > maxLike) {
						maxLike = countLike;
						maxBlank = countBlank;
						bestR = r;
						bestC = c;
					} 
					// 기존의 maxLike와 같고 maxBlank보다 크다면
					// maxBlank, bestR, bestC 갱신
					else if (countLike == maxLike && countBlank > maxBlank) {
						maxBlank = countBlank;
						bestR = r;
						bestC = c;
					} 					
					// 아직 배정 가능한 자리가 없었다면 (처음으로 빈 칸을 확인한 경우라면)
					// maxBlank, bestR, bestC 갱신
					else if (bestR == -1 && bestC == -1) {
						maxLike = countLike;
						maxBlank = countBlank;
						bestR = r;
						bestC = c;
					}
				}
			}
		}
		
		// 전체 자리에 대해 확인이 끝나면 조건에 맞는 최적의 자리에 학생 배정
		map[bestR][bestC] = list.get(idx)[0];
	}

	// 점수 계산
	public static int getScore() {
		int score = 0;
		// 전체 배열을 순차적으로 돌면서 해당 위치의 학생마다 확인
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int countLike = -1;
				// 해당 위치의 학생이 좋아하는 학생 리스트를 likeList라는 배열로 저장
				int[] likeList = new int[5];
				for (int i = 0; i < N * N; i++) {
					if (map[r][c] == list.get(i)[0]) {
						likeList = list.get(i);
						break;
					}
				}
				// 주변 4칸을 확인하며 좋아하는 학생이 있다면 count++
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (isNotOut(nr, nc)) {
						for (int i = 1; i < 5; i++) {
							if (map[nr][nc] == likeList[i]) {
								countLike++;
								break;
							}
						}
					}
				}
				
				// 점수 추가
				// 주변에 좋아하는 학생 수가 0명이면 0점
				// 1명이면 1점, 2명이면 10점, 3명이면 100점, 4명이면 1000점
				if (countLike >= 0) {
					score += (int) Math.pow(10, countLike);
				}
			}
		}
		// 전체 점수 반환
		return score;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean isNotOut(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
