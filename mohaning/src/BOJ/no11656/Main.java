// BOJ 11656번 접미사 배열

package BOJ.no11656;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		String[] arr = new String[S.length()];
		
		for (int i=0; i<S.length(); i++) {
			arr[i] = "";
			for (int j=i; j<S.length(); j++) {
				arr[i] += S.charAt(j);
			}
		}
		
//		for (int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		
	}
}
