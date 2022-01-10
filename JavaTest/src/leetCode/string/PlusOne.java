package leetCode.string;

import java.util.*;
//https://leetcode.com/problems/plus-one/
public class PlusOne {

    /* 플러스 원 */
    //내 풀이
    public Object mySolution(Object... params) {
        return null;
    }

    //다른 답
    //뒷자리부터 체크 digits[2]+1
    //값이 10이 되면 carry=1로  1을 맨 앞자리에 추가한다.
    public int[] solution(int[] digits) {
        int n = digits.length;

        for(int i = n-1; i >= 0; i--){
            digits[i]++; //마지막 값에 +1함
            if(digits[i] < 10) {
                //1,2,4와 같이 마지막 숫자가 10이 아닐때, 마지막 숫자만 +1 하고 그대로 digits를 리턴한다.
                return digits;
            }
            digits[i] = 0; //마지막이 10일 때, for문을 돌면서 ++의 결과에 영향받지 않도록 0으로 초기화
        }

        int[] result = new int[n+1]; //0,0,0,0 //마지막이 0일 때, 자릿수가 1개 더 추가되므로 1칸을 더 늘린 배열을 선언한 후
        result[0] = 1; //1,0,0,0 //맨 앞자리 원소를 1로 셋팅한다.
        return result;
    }


    //실행
    public static void main(String[] args) {
        //TestData
        int[] digits = {1,2,3};
                  // = {4,3,2,1};
                  // = {9,9,9,9}; // 10000가 되어야함

        //Call
        PlusOne po = new PlusOne();
        //Object mySolution = po.mySolution("param");
        int[] solution = po.solution(digits);

        //Output
        //System.out.println("[mySolution] Outputs ===> " + mySolution);
        System.out.println("[solution] Outputs ===> " + solution.toString());
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)
                     for문을 한 번 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     int[] digits 안에서 수행
    */
}
