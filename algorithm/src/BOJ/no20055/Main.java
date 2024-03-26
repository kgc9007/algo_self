// BOJ 20055번 컨베이어 벨트 위의 로봇
// https://www.acmicpc.net/problem/20055

package BOJ.no20055;

import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	
	static int[] belt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		belt = new int[2 * N + 1];
		for (int i = 1; i <= 2 * N; i++) {
			belt[i] = sc.nextInt();
		}
	}
}
