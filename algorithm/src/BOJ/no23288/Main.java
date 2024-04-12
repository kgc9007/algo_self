// BOJ 23288번 주사위 굴리기 2
// https://www.acmicpc.net/problem/23288

package BOJ.no23288;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 지도의 크기 N, M과 주사위의 이동 횟수 K
	static int N;
	static int M;
	static int K;
	static int[][] map;

	static boolean[][] visited;
	static int count;

	// 주사위의 현재 상태를 나타낼 배열
	// dice[1] : 윗면의 숫자, dice[2] : 앞면(북쪽을 향한 면)의 숫자, dice[3] : 오른쪽 면의 숫자
	// dice[4] : 왼쪽면의 숫자, dice[5] : 아랫면(남쪽을 향한 면)의 숫자, dice[6] : 바닥면의 숫자
	static int[] dice;

	// 주사위의 현재 위치를 나타낼 배열
	// now[0] : 현재 주사위의 위치(행), now[1] : 현재 주사위의 위치(열)
	static int[] now;

	// 주사위의 현재 방향 D
	static int D;

	// 총 점수
	static int score;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 지도의 크기 N, M과 주사위 이동 횟수 K 입력
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		// 지도 정보 입력
		map = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 주사위의 현재 상태 입력(초기상태)
		dice = new int[7];
		for (int i = 1; i < 7; i++) {
			dice[i] = i;
		}
		now = new int[2];
		now[0] = 1;
		now[1] = 1;

		// 주사위 이동 방향 D를 1(동쪽)로 초기화
		D = 1;

		// K번 이동
		while (K-- > 0) {
			move();
		}

		// 결과 출력
		System.out.println(score);

	}

	// 주사위 이동
	public static void move() {
		// 주사위의 현재 위치
		int r = now[0];
		int c = now[1];

		// 현재 주사위가 향한 방향으로 한 칸 이동
		int nr = r + dr[D];
		int nc = c + dc[D];

		// 경계를 벗어난 경우 방향을 반대로 돌려 원래 자리에서 한 칸 이동
		if (!check(nr, nc)) {
			D = (D + 2) % 4;
			nr = r + dr[D];
			nc = c + dc[D];
		}

		// visited 배열 초기화 후 dfs 실시
		// -> 이동한 칸과 같은 값으로 이어진 구역의 수(count) 계산
		visited = new boolean[N + 1][M + 1];
		visited[nr][nc] = true;
		count = 1;
		dfs(nr, nc);

		// 점수 추가
		score += map[nr][nc] * count;

		// 주사위의 현재 위치, 상태(주사위가 보고있는 방향) 변경
		now[0] = nr;
		now[1] = nc;
		roll(D);

		// 주사위를 굴린 후 방향 조정
		if (dice[6] > map[now[0]][now[1]]) {
			D = (D + 1) % 4;
		} else if (dice[6] < map[now[0]][now[1]]) {
			D = (D + 3) % 4;
		}
	}

	// 주사위 굴리기
	public static void roll(int d) {
		int[] copy = Arrays.copyOf(dice, dice.length);
		switch (d) {
		// 위로(북쪽으로) 굴린 경우
		case 0:
			dice[2] = copy[1];
			dice[1] = copy[5];
			dice[5] = copy[6];
			dice[6] = copy[2];
			break;
		// 오른쪽으로(동쪽으로) 굴린 경우
		case 1:
			dice[3] = copy[1];
			dice[1] = copy[4];
			dice[4] = copy[6];
			dice[6] = copy[3];
			break;
		// 아래쪽으로(남쪽으로) 굴린 경우
		case 2:
			dice[6] = copy[5];
			dice[5] = copy[1];
			dice[1] = copy[2];
			dice[2] = copy[6];
			break;
		// 왼쪽으로(서쪽으로) 굴린 경우
		case 3:
			dice[4] = copy[1];
			dice[1] = copy[3];
			dice[3] = copy[6];
			dice[6] = copy[4];
			break;
		default:
			break;
		}
	}

	// dfs
	public static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && map[r][c] == map[nr][nc] && !visited[nr][nc]) {
				count++;
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}

	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <= M;
	}
}
