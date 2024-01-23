// BOJ 1592번 영식이와 친구들

package BOJ.no1592;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N : 사람의 수
		// M : 공을 한사람이라도 M번 받으면 종료
		// L : 현재 위치에서 시계방향으로 또는 반시계방향으로 L번째 있는 사람에게 전달
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		// 각 사람이 공을 받은 횟수를 count 배열에 저장
		int[] count = new int[N];
		
		// 공을 던진 횟수 cnt
		// 1번 자리에 앉은 사람부터 시작 -> count[0] = 1로 초기화
		int cnt = 0;
		count[0] = 1;
		int idx = 1;
		
		// 시계방향으로 공을 던지거나
		// 반시계방향으로 공을 던지거나
		// 방향에 관계없이 똑같은 횟수!
		while (count[0] != M) {
			idx += L;
			if (idx > N) {
				idx %= N;
			}
			count[idx-1]++;
			cnt++;
		}
		
		// 결과 출력
		System.out.println(cnt);
	}
}
