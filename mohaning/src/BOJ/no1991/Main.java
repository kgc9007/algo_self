// BOJ 1991번 트리 순회
// 실패 - 노드 정보가 순서대로 주어지지 않는 경우 입력 실패

package BOJ.no1991;

import java.util.Scanner;

public class Main {

	// 결과를 저장할 StringBuilder sb
	static StringBuilder sb;

	// 트리를 표현할 배열 생성
	static char[] tree = new char[27];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N개의 줄에 걸쳐 트리의 정보 입력
		int N = sc.nextInt();
		while (N-- > 0) {
			// V, L, R 순으로 입력
			// 자식 노드가 없는 경우 . 입력
			char V = sc.next().charAt(0);
			char L = sc.next().charAt(0);
			char R = sc.next().charAt(0);

			// 입력받은 정보를 배열에 저장
			if (V == 'A') {
				tree[1] = V;
				if (L != '.') {
					tree[2] = L;
				}
				if (R != '.') {
					tree[3] = R;
				}
			} else {
				if (L != '.') {
					for (int i = 1; i < tree.length; i++) {
						if (tree[i] == V && i * 2 < tree.length) {
							tree[i * 2] = L;
						}
					}
				}
				if (R != '.') {
					for (int i = 1; i < tree.length; i++) {
						if (tree[i] == V && i * 2 + 1 < tree.length) {
							tree[i * 2 + 1] = R;
						}
					}
				}
			}

		}

		// 전위 순회 실시
		sb = new StringBuilder();
		preorder(1);
		// 결과 출력 - 전위 순회
		System.out.println(sb);

		// 중위 순회 실시
		sb = new StringBuilder();
		inorder(1);
		// 결과 출력 - 전위 순회
		System.out.println(sb);

		// 후위 순회 실시
		sb = new StringBuilder();
		postorder(1);
		// 결과 출력 - 전위 순회
		System.out.println(sb);

	}

	// 전위 순회
	// VLR
	public static void preorder(int idx) {
		if (idx >= tree.length || tree[idx] == '\0') {
			return;
		}

		sb.append(tree[idx]);
		preorder(idx * 2);
		preorder(idx * 2 + 1);

	}

	// 중위 순회
	// LVR
	public static void inorder(int idx) {
		if (idx >= tree.length || tree[idx] == '\0') {
			return;
		}

		inorder(idx * 2);
		sb.append(tree[idx]);
		inorder(idx * 2 + 1);
	}

	// 후위 순회
	// LRV
	public static void postorder(int idx) {
		if (idx >= tree.length || tree[idx] == '\0') {
			return;
		}

		postorder(idx * 2);
		postorder(idx * 2 + 1);
		sb.append(tree[idx]);

	}

}
