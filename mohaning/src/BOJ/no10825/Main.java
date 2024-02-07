// BOJ 10825번 국영수

package BOJ.no10825;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Map<String, int[]> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String name = sc.next();
			int korScore = sc.nextInt();
			int engScore = sc.nextInt();
			int mathScore = sc.nextInt();
			
			int[] score = {korScore, engScore, mathScore};
			
			map.put(name, score);
		}
		

	}
}
