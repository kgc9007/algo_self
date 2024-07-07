// BOJ 2668번 숫자고르기
// https://www.acmicpc.net/problem/2668

package BOJ.no2668;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] visited;

	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		list = new ArrayList<>();

		// - 전체 원소에 대해 dfs 실시
		// - 사이클이 발생하면 해당 사이클에 포함되는 원소들을 리스트에 추가
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}

		// 결과 출력
		System.out.println(list.size());

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	// dfs
	public static void dfs(int i, int start) {
		if (arr[i] == start) {
			list.add(start);
		}

		if (!visited[arr[i]]) {
			visited[arr[i]] = true;
			dfs(arr[i], start);
			visited[arr[i]] = false;
		}
	}
}
