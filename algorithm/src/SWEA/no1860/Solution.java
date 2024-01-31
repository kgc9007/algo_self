// SWEA 1860번 진기의 최고급 붕어빵

package SWEA.no1860;

import java.util.Scanner;

public class Solution {
	
	public static int[] count = new int[11112];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스의 수 입력
		int T = sc.nextInt();
		
		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arrivalTime = new int[N];
			for (int i=0; i<N; i++) {
				arrivalTime[i] = sc.nextInt();
			}
			arrivalTime = countingSort(arrivalTime);
			
			int lastArrival  = arrivalTime[N-1];
			
			int inventory = 0;
			int bakingTime = 0;
			int idx = 0;
			for (int time=0; time <= lastArrival; time++) {
				if (bakingTime == M) {
					inventory += K;
					bakingTime = 0;
				}
				
				
				if (time == arrivalTime[idx]) {
					inventory--;
					idx++;
				}
			}
			
		}
		
		
	}
	
	public static int[] countingSort (int[] arr) {
		int length = arr.length;
		
		int[] sortResult = new int[length];
		
		for (int i=0; i<length; i++) {
			count[arr[i]]++;
		}
		
		int idx = 0;
		for (int i=0; i<count.length; i++) {
			while (count[i] != 0) {
				sortResult[idx++] = i;
				count[i]--;
			}
		}
		
		return sortResult;
	}
	
	
}
