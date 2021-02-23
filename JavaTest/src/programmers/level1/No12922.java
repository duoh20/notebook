package programmers.level1;

public class No12922 {
	
	
	/** 수박수박수박수박수박수? **/
	//길이가 n이고 "수박수박수박.." 패턴을 유지하는 문자열을 리턴하는 함수 solution을 완성하라
	//제한 조건: n은 10,000이하인 자연
	
	
	public String solution(int n) {

        String answer = "";
        
        for(int i = 1; i < n+1; i++) {
        	 
        	if(i % 2 == 1) answer += "수";
        	else answer += "박";
        }
        
        return answer;
    }
	
	
	/*** 다른 사람의 풀이 ***/
	public String watermelon(int n){
		 
        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
        									//char의 빈 배열은 \0이 할당된다.
        //예를 들어 n에 5가 들어오면 3개 빈 char 배열이 생성되며 \0\0\0을 담은 String 객체를 생성한다.
        //이 \0을 수박으로 대체하고 n만큼 자른다. 
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(new No12922().solution(10));
	}
}
