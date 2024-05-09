// BOJ 20366번 같이 눈사람 만들래?
// https://www.acmicpc.net/problem/20366

package BOJ.no20366;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] length = new int[N];
		for (int i = 0; i < N; i++) {
			length[i] = sc.nextInt();
		}

		Arrays.sort(length);
		
		
	}
}
