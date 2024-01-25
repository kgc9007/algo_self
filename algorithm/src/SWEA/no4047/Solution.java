// SWEA 4047번 영준이의 카드 카운팅

package SWEA.no4047;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		// 테스트 케이스의 수만큼 반복
		for (int testCase=1; testCase<=T; testCase++) {
			// 각 문양별 카드가 존재하는지 확인할 배열 생성
			int[] spade = new int[13];
			int[] diamond = new int[13];
			int[] heart = new int[13];
			int[] clover = new int[13];
			
			// 가지고 있는 카드 입력
			// 3자리씩 끊어서 문양, 10의 자리, 1의 자리로 구분
			// 문양, 숫자에 맞게 배열의 값 ++
			String str = sc.next();
			for (int i=0; i<str.length(); i+=3) {
				char ch = str.charAt(i);
				int num1 = (int)(str.charAt(i+1)-48);
				int num2 = (int)(str.charAt(i+2)-48);
				
				if (ch=='S') {
					spade[num1*10 + num2-1]++;
				} else if (ch=='D') {
					diamond[num1*10 + num2-1]++;
				} else if (ch=='H') {
					heart[num1*10 + num2-1]++;
				} else {
					clover[num1*10 + num2-1]++;
				}
			}
			
			// 문양별 부족한 카드의 숫자를 확인
			// 초기값을 모두 13으로 설정
			// 만약 같은 카드가 2장 이상 있으면 ERROR 발생, 반복 종료
			// 1장이라면 해당 문양의 부족한 카드의 수 --
			int sumSpade = 13;
			int sumDiamond = 13;
			int sumHeart = 13;
			int sumClover = 13;
			boolean isError = false;
			for (int i=0; i<13; i++) {
				if (spade[i] >= 2 || diamond[i] >= 2 || heart[i] >= 2 || clover[i] >= 2) {
					isError = true;
					break;
				} else {
					if (spade[i] == 1) {
						sumSpade--;
					}
					if (diamond[i] == 1) {
						sumDiamond--;
					}
					if (heart[i] == 1) {
						sumHeart--;
					}
					if (clover[i] == 1) {
						sumClover--;
					}
				}
			}
			
			// 결과 출력
			// 에러인지 아닌지 구분
			if (isError) {
				System.out.printf("#%d ERROR%n", testCase);
			} else {
				System.out.printf("#%d %d %d %d %d%n", testCase, sumSpade, sumDiamond, sumHeart, sumClover);
			}
			
		}
	}
}
