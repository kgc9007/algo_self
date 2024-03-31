// BOJ 17825번 주사위 윷놀이
// https://www.acmicpc.net/problem/17825

package BOJ.no17825;

import java.util.Scanner;

public class Main {
	static int[] dice = new int[10];
	static int[] selected = new int[10];

	static int[][] board = new int[32][2];
	static int[] players;
	static boolean[] out;

	static int maxScore;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * [게임판 정보 입력]
		 * 
		 * board[0] : 시작, board[32] : 도착, board[31] : 마지막 칸
		 * 
		 * board[1] ~ board[20] : 가장 크게 돌아가는 길
		 * 
		 * board[5] -> board[21] ~ board[23] : 5번 칸에서 지름길로 이동
		 * 
		 * board[10] -> board[24] ~ board[25] : 10번 칸에서 지름길로 이동
		 * 
		 * board[15] -> board[26] ~ board[28] : 15번 칸에서 지름길로 이동
		 * 
		 * board[29] ~ board[31] : 중앙 ~ 마지막 지점(board[20]) 전까지
		 * 
		 */
		for (int i = 1; i < 20; i++) {
			board[i][0] = i * 2;
		}
		for (int i = 1; i <= 3; i++) {
			board[19 + i][0] = 10 + 3 * i;
		}
		for (int i = 1; i <= 2; i++) {
			board[22 + i][0] = 20 + 2 * i;
		}
		for (int i = 1; i <= 3; i++) {
			board[24 + i][0] = 29 - i;
		}
		for (int i = 1; i <= 3; i++) {
			board[27 + i][0] = 20 + 5 * i;
		}

		for (int i = 0; i < 10; i++) {
			dice[i] = sc.nextInt();
		}

		// 최대 점수 계산
		getMaxScore(0);

		// 결과 출력
		System.out.println(maxScore);
		
	}

	public static void getMaxScore(int idx) {
		if (idx == 10) {
			players = new int[4];
			out = new boolean[4];
			for (int i = 0; i < 32; i++) {
				board[i][1] = -1;
			}

			maxScore = Math.max(maxScore, getScore());
			return;
		}

		// 0번 말 이동 선택
		selected[idx] = 0;
		getMaxScore(idx + 1);

		// 1번 말 이동 선택
		selected[idx] = 1;
		getMaxScore(idx + 1);

		// 2번 말 이동 선택
		selected[idx] = 2;
		getMaxScore(idx + 1);

		// 3번 말 이동 선택
		selected[idx] = 3;
		getMaxScore(idx + 1);

//		// 4개의 말에 대해 각각 이동 가능한 경우를 모두 고려
//		for (int player = 0; player < 4; player++) {
//			selected[idx] = player;
//			getMaxScore(idx + 1);
//		}

	}

	public static int getScore() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int score = move(selected[i], dice[i]);
			if (score == -1) {
				return 0;
			}
			sum += score;
		}
		return sum;
	}

	public static int move(int player, int distance) {
		if (out[player]) {
			return -1;
		}

		// 말의 현재 위치
		int now = players[player];
		int next = 0;

		// 말의 현재 위치 표시 지우기
		board[now][1] = 0;

		// 1. 말이 갈림길에 있는 경우
		// 1-1. 5번 칸(점수 10점 위치)
		if (now == 5) {
			now += 14;
			if (distance >= 4) {
				now += 5;
			}
			next = now + distance;
		}
		// 1-2. 10번 칸(점수 20점 위치)
		else if (now == 10) {
			now += 12;
			if (distance >= 3) {
				now += 3;
			}
			next = now + distance;
		}
		// 1-3. 15번 칸(점수 30점 위치)
		else if (now == 15) {
			now += 9;
			next = now + distance;
		}
		// 2. 말이 지름길 안에 들어가 있는 경우
		// 2-1. 첫번째 지름길
		else if (now > 19 && now < 23) {
			if (now + distance > 22) {
				now += 5;
			}
			next = now + distance;
		}
		// 2-2. 두번째 지름길
		else if (now > 22 && now < 25) {
			if (now + distance > 24) {
				now += 3;
			}
			next = now + distance;
		}
		// 2-3. 세번째 지름길
		else if (now > 24 && now < 28) {
			next = now + distance;
		}
		// 3. 중앙 -> 도착점 사이에 위치한 경우
		else if (now >= 28 && now < 31) {
			next = Math.min(now + distance, 32);
		}
		// 4. 마지막 칸에 위치한 경우
		else if (now == 31) {
			next = 32;
		}
		// 5. 이외의 자리 (가장 큰 둘레를 이동하는 경우)
		// 5-1. 마지막 칸이나 밖으로 이동하는 경우
		else {
			if (now + distance > 19) {
				if (now + distance == 20) {
					next = 31;
				} else {
					next = 32;
				}
			} else {
				next = now + distance;
			}
		}

		if (next == 32) {
			players[player] = 0;
			out[player] = true;
			return 0;
		}

		if (board[next][1] != -1) {
			return -1;
		}
		board[next][1] = player;
		players[player] = next;

		return board[next][0];
	}
}
