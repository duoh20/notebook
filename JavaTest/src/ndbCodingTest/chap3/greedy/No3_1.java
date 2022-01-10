package ndbCodingTest.chap3.greedy;

public class No3_1 {

	/* 거스름돈 
	 * 카운터에 500원, 50원, 10원 동전이 무한히 존재할 때, 
	 * 손님에게 거슬러 줘야 할 돈이 N원이라면 거슬러 줘야 할 동전의 최소 개수는 몇 개일까?
	 * 단, 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
	 **/
	
	
	/* 나의 생각 */
	//가장 큰 수부터 계산한다는 힌트를 얻어서 만들었다.
	//이 식을 간단하게 변환시킬 아이디어를 생각해내지 못했다...
	public int solution(int n) {
		int coin = 0;
		int temp = n;
		
		coin += n/500;
		temp -= (500*coin);
		
		coin += temp/100;
		temp -= 100*(temp/100);
		
		coin += temp/50;
		temp -= 50*(temp/50);
		
		coin += temp/10;
		temp -= 10*(temp/10);
		
		return coin;
	}
	
	
	/* 솔루션을 보고난 후 개선 */
	public int solution2(int n) {
		int[] cashRegister = {500, 100, 50, 10}; //그렇다. 동전을 배열에 담아 반복시키면 되는 것이었다..!
		int change = 0;
		
		for(int coin : cashRegister) {
			change += n/coin;
			n %= coin; //n에 coin으로 나눈 나머지를 대입한다..!
		}
		
		return change;
	}
	
	public static void main(String[] args) {
		No3_1 sol = new No3_1();
		
		System.out.println("solution1 : " + sol.solution(1870));
		System.out.println("solution2 : " + sol.solution2(1870));
	}
}
