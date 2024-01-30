// BOJ 11399번 ATM

package BOJ.no11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 사람의 수 N 입력
		int N = sc.nextInt();
		
		// N명의 사람이 각각 돈을 뽑는데 걸리는 시간을 arr배열에 저장
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		// 시간이 짧게 걸리는 순으로 정렬
		// 배열에 이전 사람이 걸린 시간만큼 + (누적합 배열로 변경)
		// 전체 사람이 돈을 인출하는데 걸린 시간 계산
		// ex) 1 3 4 5 6 -> 1 4 9 14 20 -> 48
		
		Arrays.sort(arr);
		 
		int result = arr[0];
		for (int i=1; i<N; i++) {
			arr[i] += arr[i-1];
			result += arr[i];
		}
		
		// 결과 출력
		System.out.println(result);
	}
}
