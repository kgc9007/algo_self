// BOJ 2304번 창고 다각형

package BOJ.no2304;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 막대 기둥의 수 N 입력
		int N = sc.nextInt();
		
		// 배열 height 생성 후
		// 0~1000 위치에 막대 기둥이 있다면 높이를 저장
		int[] height = new int[1001];
		
		// 첫번째 기둥이 위치한 idx
		// 마지막 기둥이 위치한 idx
		int startIdx = 1001;
		int endIdx = 0;
		// 가장 높은 기둥의 높이와 해당 기둥이 위치한 idx
		int maxHeight = 0;
		int maxHeightIdx = 0;
		
		// N개의 기둥의 위치와 높이를 입력하며 변수 갱신
		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			
			height[L] = H;
			
			if (L < startIdx) {
				startIdx = L;
			}
			if (L > endIdx) {
				endIdx = L;
			}
			if (H >= maxHeight) {
				maxHeight = H;
				maxHeightIdx = L;
			}
		}
		
		
		// 전체 면적 계산
		int count = 0;
		
		// 현재 높이 = 0으로 초기화
		int nHeight = 0;
		
		// 왼쪽부터 최대 높이까지 오른쪽으로 한칸씩 이동하며
		// 기존 기둥보다 더 높은 높이가 나오면 nHeight 갱신
		// nHeight만큼 면적 ++
		for (int i = startIdx; i <= maxHeightIdx; i++) {
			if (height[i] > nHeight) {
				nHeight = height[i];
			}
			count += nHeight;
		}
		
		// 현재 높이 = 0으로 초기화
		nHeight = 0;
		
		// 오른쪽부터 최대 높이까지 왼쪽으로 한칸씩 이동하며
		// 기존 기둥보다 더 높은 높이가 나오면 nHeight 갱신
		// nHeight만큼 면적 ++
		for (int i = endIdx; i > maxHeightIdx; i--) {
			if (height[i] > nHeight) {
				nHeight = height[i];
			}
			count += nHeight;
		}
		
		// 결과 출력
		System.out.println(count);
	}
}
