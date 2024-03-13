// BOJ 1541번 잃어버린 괄호

package BOJ.no1541;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 식 입력
		String str = sc.next();

		// subString1, subString2를 null로 초기화하고
		// 처음으로 나오는 '-' 를 기준으로 두개의 문자열로 분할
		String subString1 = null;
		String subString2 = null;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				subString1 = str.substring(0, i);
				subString2 = str.substring(i + 1);
				break;
			}
		}

		// result = 0으로 초기화
		int result = 0;

		// '-'가 하나 이상 있는 경우
		// '-' 앞까지는 모두 '+'로 연결되어 있으니 전부 더하고
		// '-' 이후로는 괄호를 이용해 모두 뺄 수 있으니 전부 빼서 result 계산
		if (subString1 != null) {
			String[] arr1 = subString1.split("\\+");
			String[] arr2 = subString2.split("\\+|\\-");
			for (int i = 0; i < arr1.length; i++) {
				result += Integer.parseInt(arr1[i]);
			}
			for (int i = 0; i < arr2.length; i++) {
				result -= Integer.parseInt(arr2[i]);
			}
		}
		// '-'가 하나도 없는 경우
		// '+'로 나누고 전부 더하여 result 계산
		else {
			String[] arr1 = str.split("\\+");
			for (int i = 0; i < arr1.length; i++) {
				result += Integer.parseInt(arr1[i]);
			}
		}

		// 결과 출력
		System.out.println(result);
	}
}
