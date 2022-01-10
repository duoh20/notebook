package ndbCodingTest.chap4.impl;

import java.util.*;

public class no4_1 {
	
	/* 상하좌우
	 * N * N 크기의 정사각형 공간에 서 있다. 각 정사각형의 크기는 1 * 1이다.
	 * 가장 위의 좌표는 1*1이고 가장 마지막 좌표는 N * N이다.
	 * 여행가는 항상 (1*1)좌표에서 시작하여 상하좌우로 이동할 수 있다.
	 * 각 움직임은 L:왼쪽으로 한 칸, R:오른쪽으로 한 칸, U:위로 한 칸, D: 밑으로 한 칸으로 표현한다.
	 * 단, 범위를 벗어난 계획은 무시하고 다음 움직임을 진행한다. (ex: (1.1)에 있는데 L이나 U가 나오면 무시)
	 * 이 때 이동 계획서와 공간 좌표를 적은 문자열과 N이 주어질 때 최종 좌표를 구하라.*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n; //n의 범위
		do {
			System.out.println("숫자입력");
			n = sc.nextInt();
		} while(n < 0 || n >= 100);
		
		sc.nextLine();//\n이 남아있는 상태이므로 버퍼를 비워야한다.
		
		String[] plans = sc.nextLine().split(" ");
		int x = 1, y = 1; //시작점 (1, 1)
		
		//L R U D의 이동방향
		char[] moveTypes = {'L', 'R', 'U', 'D'}; //이동 가능한 모든 타입
		int[] dx = {0,0,-1,1}; //각 인덱스의 이동에 따른 x의 증감
		int[] dy = {-1,1,0,0}; //각 인덱스의 이동에 따른 y의 증감
		
		//이동 계획을 확인하기
		//들어온 이동 방향이 어떻게 되는지 계산한다.
		for(int i = 0; i < plans.length; i++) {
			char plan = plans[i].charAt(0);
			int nx = -1, ny = -1; //초기화
			
			for(int j = 0; j <4; j++) {
				if(plan == moveTypes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			
			//이동 범위를 벗어나면 무시한다. 즉, 값이 1이거나 경계값에 있으면 움질일 수 없다.
			if(nx < 1 || ny < 1 || nx > n || ny > n)  continue;
			
			//이동 범위를 벗어나지 않는다면 이동한다.
			x = nx;
			y = ny;
		}
		
		System.out.println(x + " " + y);
	}
}
