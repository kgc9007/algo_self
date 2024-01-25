// BOJ 2851번 슈퍼 마리오

package BOJ.no2851;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10개의 버섯의 점수를 score 배열에 입력
		// 누적합을 accSum 배열에 입력
		int[] score = new int[10];
		int[] accSum = new int[10];
		int sum = 0;
		
		for (int i=0; i<score.length; i++) {
			score[i] = sc.nextInt();
			sum += score[i];
			accSum[i] = sum;
		}
		
		// i번째 누적합과의 차이 diff를 선언 후 100으로 초기화
		// 기존 diff와 새 diff(새로운 누적합과 100의 차이) 비교
		// 새 diff가 기존 diff보다 작거나 같으면 결과를 변경
		int diff = 100;
		int result = 0;
		for (int i=0; i<score.length; i++) {
			if (Math.abs(accSum[i]-100) <= diff) {
				result = accSum[i];
				diff = Math.abs(accSum[i]-100);
			}
		}
		
		// 결과 출력
		System.out.println(result);
		
	}
}
