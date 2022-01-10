package leetCode.string;
import leetCode.Template;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

//https://leetcode.com/problems/license-key-formatting/
public class LicenseKeyFormatting {

    /* 라이센스 키 포맷(LicenseKeyFormatting) */
    //s는 "-",숫자,영문대소문자가 조합된 문자열, k는 정수,
    //-로 구분한 문자 중 첫 자리를 제외한 나머지 자리의 문자 갯수는 k 숫자에 정제하여 라이센스 키를 리턴하라.
    //맨 첫번째의 문자는 최소 한 자 이상이며 영문은 모두 대문자로 치환한다.

    //내 풀이
    public String mySolution(String s, int k) {
        String keyStr = s.replace("-", "").toUpperCase();
        int keyStrLength = keyStr.length();
        int KeyStrFirstLength = keyStrLength % k;

        StringBuilder sb = new StringBuilder();
        sb.append(keyStr.substring(0, KeyStrFirstLength));

        int idx = KeyStrFirstLength;
        int keyStrPartLength = keyStrLength/k;
        for(int i = 0; i < keyStrPartLength; i++) {
            sb.append(keyStr.substring(idx, idx+k));
            if(i < keyStrPartLength - 1) {
                sb.append("-");
            }
            idx += k;
        }

        return sb.toString();
    }

    //해설
    //1. replace로 - 제거 후 toUpperCase()하여 대문자로 변환
    //2. 1에서 정제한 문자열을 담은 StringBuilder 객체 생성
    //3. 첫번째 문자열이 몇 개일지 알 수 없으므로 뒤에서부터 "-" 삽입
    public String solution(String s, int k) {
        //1.delete - and change upper case
        String newStr = s.replace("-", "").toUpperCase();

        //2. k개로 파싱하고 - 삽입
        StringBuilder sb = new StringBuilder(newStr);

        int len = sb.length();
        for(int i = k; i < len; i=i+k) {
            sb.insert(len-i, "-");
            //StringBuilder.insert(int offset, String str) 지정 인덱스에 문자열 삽입
        }
        return sb.toString();
    }

    //실행
    public static void main(String[] args) {
        //TestData
        String  s = "5F3Z-2e-9-w";
        int k = 4; //answer: 5F3Z-2E9W


        //Call
        LicenseKeyFormatting lkf = new LicenseKeyFormatting();
        String mySolution = lkf.mySolution(s, k);
        String solution = lkf.solution(s, k);

        //Output
        System.out.println("[mySolution] Outputs ===> " + mySolution);
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** String 보다 StringBuilder를 사용하자. ***/
    /*
        + 연산으로 문자열을 바꿀 수 있지만 String은 불변 클래스로,
        해당 연산이 일어날 때마다 새로운 String 객체를 생성한다.
        String에 + 연산을 하면 각 String 객체의 주소 값이 가비지 컬렉터가 동작하기 전까지 heap 영역에 쌓이게 된다.
        단, String 객체는 불변하므로 동기화를 고려하지 않아도 된다(thread safe)

        StringBuilder vs StringBuffer
        두 객체 모두 변경 가능(mutable)하다.
        StringBuffer는 멀티스레드 환경에서 동기화를 보장함
        StringBuilder는 동기화를 고려하지 않아 StringBuffer보다 연산 속도가 빠름
    */
    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     Set<String> set = new HashSet()에서 for를 한 번 실행 시킴
    */
}
