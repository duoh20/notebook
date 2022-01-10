package leetCode;
import java.util.*;

public class Template {

    /* Title */
    //내 풀이
    public Object mySolution(Object... params) {
        return null;
    }

    //다른 답
    public Object solution(Object... params) {
        return null;
    }

    //실행
    public static void main(String[] args) {
        //TestData

        //Call
        Template template = new Template();
        Object mySolution = template.mySolution("param");
        Object solution = template.solution("param");

        //Output
        System.out.println("[mySolution] Outputs ===> " + mySolution);
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     Set<String> set = new HashSet()에서 for를 한 번 실행 시킴
    */
}
