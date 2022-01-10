package ndbCodingTest.chap3.greedy;

import java.util.*;

public class No3_2 {
	
	/* 큰 수의 법칙
	 * 조건 담은 문자열과 임의의 정수를 담은 문자열 있다.
	 * 조건은 "N M K"로 임의의 정수는 N개가 주어지고,
	 * 임의의 정수를 담은 문자열에서 가장 큰 수를 M번 더 하되, K번을 초과해서 더할 수 없다.
	 * 결과가 가장 큰 수가 나오도록 main 메소드를 완성해보자.
	 **/
	
	
	public static void main(String[] args) {
		
		//첫번째 조건 입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		//두번째 조건 입력 받기
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//가장 큰 수와 두번째로 큰 수 골라내기
		Arrays.sort(arr);
		int one = arr[n-1];
		int two = arr[n-2];
		
		// m번더하고 k번 반복 불가
		int answer = 0;
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= k; j++) {
				answer += one;
				i++;
			}
			answer += two;
		}
		
		System.out.println(answer);
	}
	
	/* ndb 솔루션
	 * 계산을 for문을 사용하지 않고 해결하여 성능을 향상시켰다.
	 * 가장 큰 수가 더해지는 횟수를 계산하여서 곱셈으로 연산했다.
	 * (m/(k+1))*k에 나머지(m%(k+1))을 더하면 가장 큰 수가 더해지는 횟수를 구할 수 있다.
	 * 두번째로 큰 수는 전체 횟수 m에서 큰 수 더해지지는 횟수를 뺀 만큼 더해준다.
	 * */
}
