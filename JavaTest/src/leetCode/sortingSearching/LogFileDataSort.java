package leetCode.sortingSearching;

import java.util.*;

public class LogFileDataSort {

    /* 로그 파일의 데이터 재정렬(LogFileDataSort) */
    //배열로 logs가 주어질 때 각 로그의 구분자는 공백이고, 첫번째 단어는 식별자다.
    //(문자파트) 모든 문자는 영문 소문자, (숫자파트) 숫자만 가능하다
    //재정렬 조건은 다음과 같다.
    //문자파트는 모든 숫자파트 앞에 위치하고, 사전적으로 정렬된다.
    //정제한 결과가 중복되면 식별자 오름차순으로 정렬한다.
    //숫자파트는 기존 순서를 유지한다.


    //풀이
    //Comparator를 직접 구현하는 것이 핵심
    public String[] solution(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            //식별자와 두번째 문자열을 나눔
            String[] split1 = s1.split(" ",2); //공백으로 1번(limit -1) 쪼갠다.
            String[] split2 = s2.split(" ",2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0)); //두번째 영역의 첫번째 글자를 뽑아와서 정렬
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) { //1.모두 문자
                int comp = split1[1].compareTo(split2[1]); //-는 오름차순 (compareTo = 같으면 0, 내림차순 1, 오름차순 -1 반환)
                if(comp == 0) {
                    return  split1[0].compareTo(split2[0]); //두번째 영역이 같으면 식별자를 비교해서 정렬
                } else {
                    return comp;
                }
            } else if(isDigit1 && isDigit2) { //2.모두 숫자
                return 0;
            } else if(isDigit1 && !isDigit2) { //3.첫번째 숫자, 두번째 문자
                return 1;
            } else { //3.첫번째 문자, 두번째 슷자: compareTo에 의해 오름차순으로 소팅됨
                return -1;
            }
        });
        return logs;
    }

    //실행
    public static void main(String[] args) {
        //TestData
        String[] logs = {"dig1 8 2 3 1",
                         "let1 abc cat",
                         "let3 2 5",
                         "let2 good dog book",
                         "let3 abc zoo"};
        //Expection [let1 abc cat, let3 abc zoo, let2 good doog book, dig1 8 2 3 1, let3 2 5]

        //Call
        LogFileDataSort lfds = new LogFileDataSort();
        String[] solution = lfds.solution(logs);

        //Output
        System.out.println("[solution] Outputs ===> " + Arrays.toString(solution));
    }
}
