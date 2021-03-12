package programmers.level1;

import java.util.Arrays;
import java.util.Scanner;

public class No68935 {
	
	/* 3진법 뒤집기 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String temp = "";
        while(n > 0) {
        	temp += n % 3; 
            n /= 3;
        }
       
        int[][] calc = new int[2][temp.length()];
        
        for(int i = 0; i < 2; i++) {
            
            for(int j = 0; j < temp.length(); j++) {
                 if(i == 0) {
                    calc[0][j] = Integer.parseInt(temp.substring(j, j+1));
                 } else {
                    calc[1][j] = (int)Math.pow(3, j);
                 }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < calc[0].length; i++) {
            answer += calc[0][i] * calc[1][(calc[0].length -1) - i];
        }
        
        System.out.println(answer);
        System.out.println(new No68935().solution1(125));
        
	}
	
	
	
	/* 다른 사람의 풀이 */
	//Integer.toString(n,3) => 바로 3진법의 스트링으로 변환해준다.
	//StringBuilder 클래스의 reverse()를 사용했다.
	//parseInt는 10진수 정수 해상도로 문자열을 인수하는데 사용하기도 한다.
	//parseInt(변환할 수, 기수)로 선언하면 해당 진법의 수를 10진수로 변환한다.
	public int solution1(int n) {
        
		String a = Integer.toString(n, 3);

//        while(n > 0){
//            a = (n % 3) + a;
//            n /= 3;
//        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    }
}
