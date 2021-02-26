package programmers.level1;

public class No12918 {
	
	/** 문자열 다루기 기본 **/
	//문자열 길이가 4 혹은 6이고 숫자로만 구성되어있는지 확인하는 함수 solution을 완성하라.
	//제한 조건: s 길이는 1이상 8 이하이다.
	
	public boolean solution(String s) {
        
        boolean answer = true;
       
        return isNumeric(s) == true && s.length() == 4 || s.length() == 6 ? true : false;
    }
    
    public boolean isNumeric(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
	
	
	/*** 다른 사람의 풀이 ***/
    //try-catch문 활용한다.
	public boolean solution2(String s) {
		
		if(s.length() == 4 || s.length() == 6) {
			
			try {
				Integer.parseInt(s);
				return true;
			} catch(NumberFormatException e) {
				return false;
			}
		}
		
		return false;
	}
	
	/*** 다른 사람의 풀이 ***/
    //정규식을 활용했다. 길이 검사도 정규식으로 하면 좋았을 것이라는 의견이 있었다.
	//길이 검사: ^[0-9]{4}|{6}$
	public boolean solution3(String s) {
		 
		if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(new No12918().solution("a123"));
		System.out.println(new No12918().solution2("a123"));
		System.out.println(new No12918().solution3("a123"));
	}
}
