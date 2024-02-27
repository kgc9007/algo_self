// BOJ 1991번 트리 순회

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

	}
	
	// 전위 순회
	public static void preorder() {
		sb = new StringBuilder();
	}
	
	// 중위 순회
	public static void inorder() {
		sb = new StringBuilder();
		
	}

	// 후위 순회
	public static void postorder() {
		sb = new StringBuilder();
		
	}
	
}
