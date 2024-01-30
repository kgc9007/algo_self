// BOJ 13300번 방 배정

package BOJ.no13300;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] student = new int[2][6];
		
		for (int i=0; i<N; i++) {
			student[sc.nextInt()][sc.nextInt()-1]++;
		}
		
		int rooms = 0;
		for (int i=0; i<student.length; i++) {
			for (int j=0; j<student[i].length; j++) {
				if (student[i][j]%K == 0) {
					rooms += student[i][j]/K;
				} else {
					rooms += student[i][j] / K + 1;
				}
			}
		}
		
		System.out.println(rooms);
	}
}
