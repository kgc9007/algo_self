// BOJ 15829번 Hashing

package BOJ.no15829;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열 길이 L, 문자열 입력
		int L = sc.nextInt();
		String str = sc.next();
		
		// 해시 값 계산
		long result = 0;
		for (int i=L-1; i>=0; i--) {
			result = result * 31 + (str.charAt(i) - 96);
			result %= 1234567891;
		}

		System.out.println(result);
	}
}
