package ndbCodingTest.chap4.impl;

import java.util.*;

public class no4_2 {
	
	
	/* 시각
	 * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지 모든 시각 중에서
	 * 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하라. */
	
	
	public static boolean check(int h, int m, int s) {
		if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			n = sc.nextInt();
		} while(n < 0 || n > 23);
		
		int result = 0;
		
		for(int i = 0; i <= n; i++) {
			
			for(int j = 0; j < 60; j++) {
				for(int k = 0; k <60; k++) {
					if(check(i, j, k)) result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
