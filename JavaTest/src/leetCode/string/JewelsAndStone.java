package leetCode.string;
import java.util.*;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStone {

    /* 보석과 돌(JewelsAndStone) */
    //내 풀이
    public int mySolution(String jewels, String stones) {
        int answer = 0;
        char[] jArr = jewels.toCharArray();
        char[] sArr = stones.toCharArray();

        for(int i = 0; i < jArr.length; i++) {
            char jewel = jArr[i];
            for(int j = 0; j < sArr.length; j++) {
                if(sArr[j] == jewel) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public int solution(String jewels, String stones) {
        //1.DataStructure
        //보석은 중복되지 않는다. 따라서 중복이 허용되지 않는 set에 담는다.
        Set<Character> set = new HashSet<>();

        //2.for while
        //스트링을 char 배열에 담아 set에 하나씩 집어넣는다.
        char[] jArr = jewels.toCharArray();
        for(int i=0; i<jArr.length; i++) {
            set.add(jArr[i]);
        }

        int answer = 0;
        char[] sArr = stones.toCharArray();
        for(int i=0; i<sArr.length; i++) {
            if(set.contains(sArr[i])) {
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        //TestData
        String jewels = "aA";
        String stones = "aAAbbbb";

        //Call
        JewelsAndStone ja = new JewelsAndStone();
        int mySolution = ja.mySolution(jewels, stones);
        int solution = ja.solution(jewels, stones);

        //Output
        System.out.println("[mySolution] Outputs ===> " + mySolution);
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 : O(N) ***/
    /*
        시간복잡도
        대상(Source): char[] sArr에서 for문 한 번 실행
                     시간 복잡도는 O(N)
        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     Set<String> set = new HashSet()에서 for를 한 번 실행 시킴
    */
}
