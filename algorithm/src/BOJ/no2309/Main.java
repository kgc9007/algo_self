// BOJ 2309번 일곱 난쟁이

package BOJ.no2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 9명의 난쟁이의 키 입력, 키의 합 계산
		int[] arr = new int[9];
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		} 
		
		// 정답을 저장할 배열 result 선언
		int[] result = new int[7];
		
		// 두 명의 난쟁이의 키를 빼서 100이 되는 경우
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					// 전체 난쟁이 중 해당하는 두명의 난쟁이를 빼고
					// result 배열에 입력
					int idx = 0;
					for (int k=0; k<arr.length; k++) {
						if (k != i && k != j) {
							result[idx++] = arr[k];
						}
					}
				}
			}
		}
		
		// 정렬 후 결과 출력
		Arrays.sort(result);
		
		for (int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}

}
