package ndbCodingTest.chap3.greedy;

import java.util.Scanner;

public class No3_4 {
	
	/* 1이 될 때까지
	 * 임의의 수 N이 1이 될 때까지 두 과정 중 하나를 반복적으로 선택하여 수행하려 한다.
	 * 두 번째 연산은 N이 K로 나누어 떨어질 때만 선택 가능하다.
	 * 1. N에서 1을 뺸다 / 2. N을 K로 나눈다.
	 * N과 K가 주어질 떄 N이 1이 될 떄까지 1 또는 2 과정의 최소 횟수를 구하라.
	 * */
	
	public static void main(String[] args) {
		//K로 나누고 나머지는 1로 뺸다고 가정한다.
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while(n != 1) {
			n = (n % k == 0 ? n / k : n - 1);
			result++;
		}
		
		System.out.println(result);
	}
	
	/* ndbSolution
	 * 1,2를 조합해 가장 적게 연산하려면 최대한 많이 나눠야한다.
	 * */
}
