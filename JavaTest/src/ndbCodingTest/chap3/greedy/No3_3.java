package ndbCodingTest.chap3.greedy;
import java.util.*;

public class No3_3 {
	
	/* 숫자 카드 게임
	 * 여러 개의 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다
	 * 카드는 N(행의 갯수) * M(열의 갯수) 형태로 놓여 있다.
	 * 뽑으려는 카드 행을 선택하고, 행에 포함된 카드 중 가장 낮은 숫자의 카드를 뽑아야한다.
	 * 각 행에서 가장 작은 숫자의 카드를 뽑고, 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야한다.
	 * 게임의 룰에 맞는 결과를 출력하라.
	 * */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		//입력과 동시에 가장 작은 수를 뽑아내도록 풀이하였다.
		for(int i = 0; i < n; i++) { //각 행에서 가장 작은 수를 뽑은 후 그중에서 가장 큰 값을 뽑는다.
			
			int minVal = 10001; //최대 범위가 1000이기 때문에 가장 큰 값은 10001로 초기화 했다.
			for(int j = 0; j < m; j++) { //열
				int x =sc.nextInt();
				minVal = Math.min(minVal, x);
			}
			result = Math.max(result, minVal);
		}
		System.out.println(result);
		
	}
	
	/* ndb solution
	 * Math 클래스의 min()과 max()을 사용해 입력과 동시에 최소 값, 최대값을 비교했다.
	 */
}
