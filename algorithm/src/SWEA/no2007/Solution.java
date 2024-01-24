// SWEA 2007번 패턴 마디의 길이

package SWEA.no2007;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전체 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 테스트 케이스(문자열) 입력
			String str = sc.next();
			
			// 입력한 문자열을 한글자씩 arr 배열에 입력
			char[] arr = new char[30];
			for (int i=0; i<30; i++) {
				arr[i] = str.charAt(i);
			}
			
			// 마디 길이 구하기
			// 1. 첫번째 글자와 같은 글자가 나올때까지 길이를 증가시키면서 확인
			// 2. 같은 글자가 나오면
			// 3. 마디인지를 확인하기 위해 구한 length만큼 한글자씩 비교
			// 4. 만약 마디가 아니라면 flag를 false로 초기화 하고 length++
			// 5. 마디가 맞다면(break 되지 않으면) -> flag = true
			// 6. 결과 출력, 다음 테스트 케이스로 break
			int length = 1;
			boolean flag = false;
			
			for (int i=1; i<=10; i++) {
				if (arr[0] == arr[i]) {
					flag = true;
					for (int j=0; j<length; j++) {
						if (arr[j] != arr[j+length]) {
							flag = false;
							length++;
							break;
						}
					}
				} else {
					length++;
				}
				
				if (flag) {
					System.out.printf("#%d %d%n", testCase, length);
					break;
				}
			}
			
			
		}
		
		
	}
}
