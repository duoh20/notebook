package leetCode.string;
import java.util.*;

//https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmailAddress {

    //고유한 이메일(UniqueEmailAddress)
    //===== Basic =====//
    public int solve1(String[] emails) {

        //1.data structure
        Set<String> set = new HashSet<>(); //중복을 허용하지 않음

        //2.for while  : String을 charAt()으로 처리함
        for(String email : emails) {
            //순회하면서 로컬네임과 도메인네임을 각각 정재한다.
            int atIdx = email.indexOf("@");
            String localName = makeLName(email.substring(0, atIdx));
            String domainName = email.substring(atIdx);

            //정제한 로컬네임과 도메인 네임을 합쳐 이메일을 Set에 담는다.
            //Set은 중복을 허용하지 않으므로, 중복된 이메일은 담기지 않는다.
            set.add(localName + domainName);
        }

        return set.size();
    }

    private String makeLName(String email) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < email.length(); i++) {

            if(email.charAt(i) == '.') {
                continue;
            }
            if(email.charAt(i) == '+') {
                break;
            }

            sb.append(email.charAt(i));
        }
        return sb.toString();
    }


    //===== String.split() =====//
    public int solve2(String[] emails) {

        //1.data structure
        Set<String> set = new HashSet<>(); //중복을 허용하지 않음

        //2.for while
        for(String email : emails) {
            String[] parts = email.split("@");
            String[] lName = parts[0].split("\\+");
            //splict("+")는 Dangling meta character '+' near index 0 에러가 발생한다.
            //splict("\\+") 또는 splict("[+]")를 사용하자.

            set.add(lName[0].replace(".", "") + parts[1]);
            //정제한 로컬네임과 도메인 네임을 합쳐 이메일을 Set에 담는다.
        }

        return set.size();
    }

    //실행
    public static void main(String[] args) {

        //TestData
        String[] emails = {"test.email+james@coding.com",
                "test.e.mail+toto@coding.com",
                "testemail+tom@cod.ing.com",
                "a@coding.com"};

        //Call
        UniqueEmailAddress uea = new UniqueEmailAddress();
        int solve1 = uea.solve1(emails);
        int solve2 = uea.solve1(emails);

        //Output
        System.out.println("[solve1] Outputs ===> " + solve1);
        System.out.println("[solve2] Outputs ===> " + solve2);
    }

    //문제 분석하는 방법
    //1. 문제분석    : 문제를 정확히 이해하고 분석 내용 정리
    //2. 규칙찾기    : 분석 내용으로 규칙찾기
    //3. 코딩화     : 분석 내용으로 알맞은 구현방법 찾기
    //4. 알고리즘 적용: 알고리즘 정하고 담을 그릇 정하기(사전 지식 필요)

    /* 1.문제 분석
    *   로컬네임 + 도메인 네임
    *   로컬네임에서 . 무시
    *   로컬네임에서 + 이후로 나오는 문자열 무시
    *   도메인 네임에서 .이 들어가면 고유하다.
    * */

    /* 2. 규칙 찾기
    *   . => Continue로 빼기
    *   + => break로 빼기
    *   Set<String> : 유니크한 값이기 때문에 Set에 담음
    * */


    /*** 시간 복잡도와 공간 복잡도 계산 : O(N) ***/
    /*
        시간복잡도
        대상(Source): emails 배열 안에서 for문을 돌리며 원소를 꺼내와 로컬 네임과 도메인을 연산했다.
                     시간 복잡도는 O(NM) -> N:이메일 수 / M: 이메일 길이
        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     Set<String> set = new HashSet()은 데이터를 저장할 때마다 for를 한 번씩 돌림
    */
}
