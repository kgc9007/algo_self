// BOJ 12919번 A와 B 2
// https://www.acmicpc.net/problem/12919

package BOJ.no12919;

import java.util.Scanner;

public class Main {
	
	static boolean possible;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		String T = sc.next();

		check(S, T);
		
		if (possible) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void check(String S, String T) {
		if (S.equals(T)) {
			possible = true;
			return;
		}
		
		if (S.length() == T.length()) {
			return;
		}
		
		if (T.charAt(T.length() - 1) == 'A') {
			T = T.substring(0, T.length() - 1);
			check(S, T);
			T += "A";
		} 
		if (T.charAt(0) == 'B'){
			T = T.substring(1);

			StringBuilder sb = new StringBuilder(T);
			T = sb.reverse().toString();
			check(S, T);
		}
		
		
	}
}
