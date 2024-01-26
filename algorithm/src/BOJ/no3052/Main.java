// BOJ 3052번 나머지

package BOJ.no3052;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 크기가 42인 boolean 배열을 만들어
		// 입력받은 숫자를 42로 나눈 나머지에 해당하는 배열의 값을 true로 변경
		boolean[] check = new boolean[42];
		
		for (int i=0; i<10; i++) {
			int num = sc.nextInt();
			check[num%42] = true;
		}
		
		// 전체 배열을 탐색해서 true의 개수 확인
		int cnt = 0;
		for (int i=0; i<check.length; i++) {
			if (check[i]) {
				cnt++;
			}
		}
		
		// 결과 출력
		System.out.println(cnt);
	}

}
