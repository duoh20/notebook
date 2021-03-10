package programmers.level1;

public class No12948 {
	
	
	/* 핸드폰 번호 가리기
	 * 핸드폰 뒷자리 4자리만 숨기고 ****으로 표시하세요.
	 * */
	public String solution(String phone_number) {
        
	       String answer = ""; 
	       for(int i = 0; i < phone_number.length(); i++) {
	           if(i < phone_number.length() - 4)
	                answer += "*";
	           else
	            answer += phone_number.charAt(i);   
	       }
	        return answer;
	 }
	
	
	/* 다른 사람 풀이 */
	//전화번호를  array로 바꾸어 계산했다.
	public String solution1(String phone_number) {
	     char[] ch = phone_number.toCharArray();
	     
	     for(int i = 0; i < ch.length - 4; i ++){
	         ch[i] = '*';
	     }
	     return String.valueOf(ch);
	     
	}
	
	public String solution2(String phone_number) {
		    return phone_number.replaceAll(".(?=.{4})", "*");
		    //정규식을 사용했다.
		    //. -> 임의의 문자 한 개 / (?=.) -> 뒷쪽에 임의의 문자 한 개를 제외하고 선택/ {숫자} -> 숫자 만큼의 자릿수
		    //.(?=.{4}) ==> 뒤쪽서 임의의 문자 4개를 제외한 임의의 문자 한 개 선택
	}
}
