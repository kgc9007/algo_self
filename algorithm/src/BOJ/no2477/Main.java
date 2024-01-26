// BOJ 2477번 참외밭

package BOJ.no2477;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int d = 0;
		for (int i=0; i<K; i++) {
			for (int j=0; j<K-1-d; j++) {
				System.out.print(" ");
			}
			for (int j=K-1-d; j<=K-1+d; j++) {
				System.out.print("*");
			}
			d++;
			System.out.println();
		}
		
		
		
	}

}
