// BOJ 14719번 빗물
// https://www.acmicpc.net/problem/14719

package BOJ.no14719;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 2차원 세계의 세로 길이 H
		// 2차원 세계의 가로 길이 W
		int H = sc.nextInt();
		int W = sc.nextInt();

		// 각 블록의 높이를 저장할 배열
		int[] heights = new int[W];

		// 블록의 높이를 입력하며 최고 높이와 해당 블록의 인덱스 확인
		int maxHeight = 0;
		int maxHeightIdx = 0;
		for (int i = 0; i < W; i++) {
			heights[i] = sc.nextInt();
			if (heights[i] > maxHeight) {
				maxHeight = heights[i];
				maxHeightIdx = i;
			}
		}

		// 고이는 빗물의 총량 계산을 위해 sum = 0으로 초기화
		int sum = 0;

		// 가장 왼쪽에서 시작해서 최고 높이인 블록까지 이동하며 고이는 빗물의 양 계산
		// 현재 높이(최고 높이) 0 으로 초기화
		int nHeight = 0;
		for (int i = 0; i < maxHeightIdx; i++) {
			// 이전 최고 높이보다 작은 블록이라면 높이 차이만큼 빗물이 고임
			if (nHeight > heights[i]) {
				sum += nHeight - heights[i];
			} else {
				nHeight = heights[i];
			}
		}

		// 가장 오른쪽에서 시작해서 최고 높이인 블록까지 이동하며 고이는 빗물의 양 계산
		// 현재 높이(최고 높이) 0 으로 초기화
		nHeight = 0;
		for (int i = W - 1; i > maxHeightIdx; i--) {
			// 이전 최고 높이보다 작은 블록이라면 높이 차이만큼 빗물이 고임
			if (nHeight > heights[i]) {
				sum += nHeight - heights[i];
			} else {
				nHeight = heights[i];
			}
		}

		// 결과 출력
		System.out.println(sum);
	}
}
