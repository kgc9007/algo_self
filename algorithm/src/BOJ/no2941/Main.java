// BOJ 2941번 크로아티아 알파벳

package BOJ.no2941;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 단어 입력
		String word = sc.next();

		// 알파벳을 세자!
		int cnt = 0;
		for (int i = 0; i < word.length(); i++) {
			switch (word.charAt(i)) {
			// i번째 글자가 c이면
			// c=/c-/c 중 한가지
			case 'c':
				if (i < word.length() - 1) {
					if (word.charAt(i + 1) == '=' || word.charAt(i + 1) == '-') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
				break;
			// i번째 글자가 d이면
			// dz=/d-/d 중 한가지
			case 'd':
				if (i < word.length() - 1) {
					if (word.charAt(i + 1) == 'z') {
						if (i < word.length() - 2) {
							if (word.charAt(i + 2) == '=') {
								cnt++;
								i += 2;
							} else {
								cnt++;
							}
						} else {
							cnt++;
						}
					} else if (word.charAt(i + 1) == '-') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
				break;
			// i번째 글자가 l이면
			// lj/l 중 한가지
			case 'l':
				if (i < word.length() - 1) {
					if (word.charAt(i + 1) == 'j') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
				break;
			// i번째 글자가 n이면
			// nj/n 중 한가지
			case 'n':
				if (i < word.length() - 1) {
					if (word.charAt(i + 1) == 'j') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
				break;
			// i번째 글자가 s이면
			// s=/s 중 한가지
			case 's':
				if (i < word.length() - 1) {
					if (word.charAt(i + 1) == '=') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
				break;
			// i번째 글자가 z이면
			// z=/z 중 한가지
			case 'z':
				if (i < word.length() - 1) {
					if (word.charAt(i + 1) == '=') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
				break;
			// 이외의 알파벳은 그대로 진행
			default:
				cnt++;
				break;
			}

		}

		// 결과 출력
		System.out.println(cnt);

	}

}
