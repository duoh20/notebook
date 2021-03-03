package programmers.level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class No12926 {
	
	public String solution(String s, int n) {
        
		/* 시저 암호 */
        String answer = "";
        char ch;
        
        for(int i =0; i < s.length(); i++) {
            ch = s.charAt(i);
            
            if(ch >= 'a' && ch <= 'z') {
                ch += n;
                if(ch > 'z') {
                    ch -= 26;
                }
            } else if(ch >= 'A' && ch <= 'Z') {
                ch += n;
                if(ch > 'Z') {
                    ch -= 26;
                }
            }
            answer += ch;    
        }
        return answer;
    }

	/* 다른 사람의 풀이 */
	String caesar(String s, int n) {
	    String result = "";
	    n = n % 26;
	    
	    for (int i = 0; i < s.length(); i++) {
		  char ch = s.charAt(i);
		  if (Character.isLowerCase(ch)) {
		    ch = (char) ((ch - 'a' + n) % 26 + 'a');
		  } else if (Character.isUpperCase(ch)) {
		    ch = (char) ((ch - 'A' + n) % 26 + 'A');
		  }
		  result += ch;
		}
	    
	    return result;
	}
}
