// BOJ 15829번 Hashing

package BOJ.no15829;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		String str = sc.next();
		
		long result = 0;
		for (int i=L-1; i>=0; i--) {
			result = result * 31 + (str.charAt(i) - 96);
		}

		System.out.println(result);
	}
}
