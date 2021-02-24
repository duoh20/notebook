package programmers.level1;

public class No12912 {
		
		/** 두 정수 사이의 합  **/
		//두 정수 a, b가 주어지면 그 사이에 속한 모든 정수 합을 리턴하는 함수를 완성하라
		//제한 조건 1) a, b가 같으면 둘 중 아무 수나 리턴
		//제한 조건 2) a, b 대소관계는 정해져 있지 않으며 범위는 -10,000,000 이상 10,000,000 이하인 정수
	
	/* 나의 풀이 */
	public long solution(int a, int b) {

        long answer=0;
		
		if(a == b) {
			return a;
		} else if (a > b) {
			for(long i = b; i <= a; i++) {
				answer += i;
			}
		} else {
			for(long i = a; i <= b; i++) {
				answer += i;
			}
		}
		return answer;
	}
	
	/* 다른 사람의 풀이 1 */
    public long compareInt(int a, int b) {
    	//Math.min()과 Math.max로 대소 비교
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
    	//등차수열의 합 공식
        return (b - a + 1) * (a + b) / 2;
    }
    
    /* 다른 사람의 풀이 2 */
    public long sumAtoB2(int a, int b) {
        long answer = 0;
        for (int i = ((a < b) ? a : b); i <= ((a < b) ? b : a); i++) 
            answer += i;

        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(new No12912().solution(3, 3));
	}
}
