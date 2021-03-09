package programmers.level1;

import java.util.Arrays;

public class No12919 {
	
	/* 서울에서김서방 찾기
	 * String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아,
	 * "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하라
	 **/
	//1. seoul은 길이 1이상 1000 이하, 1이상 20이하의 문자열,kim은 반드시 있고, 1번만 나타난다.
	public String solution(String[] seoul) {
        
        String answer = "";
        
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        
        return answer;
    }
	
	
	
	//다른 사람의 풀이1
	//Arrays의 asList()를 사용해 배열을 ArrayList로 변환해 덱스를 조회했다.
	public String solution1(String[] seoul){
 
        int x = Arrays.asList(seoul).indexOf("Kim");
        //성능에 있어 int와 참조 변수가 가장 빠르다.

        return "김서방은 "+ x + "에 있다";
    }
	
	
	//다른 사람의 풀이2
	public String solution2(String[] seoul) {
        
        int x = 0;
       
        //향상된 for문으로 처리하기
        for(String person : seoul) {
        	if(person.equals("Kim")) 
        		break;
        	x++;
        }
        
        //for문으로 처리하기
        //for문의 초기식; 조건식; 증감식;은 생략 가능한 특징도 고려해보자.
        //인덱스 x를 외부에서 초기화하여 증가시킬 수도 있다.
        x = 0;
        for(; x < seoul.length; x++) {
            if(seoul[x].equals("Kim"))
                break;
        }
        
        return "김서방은 "+ x + "에 있다";
    }
}
