package leetCode.sortingSearching;

import java.util.*;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperature {

    /* 일일온도(DailyTemperature) */
    //일일 온도를 나타내는 int 배열(temperatures)이 주어진다.
    //더 따듯한 날씨의 날을 얻기 위해 해당 날짜 이후에 기다려야하는 날짜 수를 배열로 리턴하라,
    //더 따듯한 날이 오지 않는다면 0을 리턴하라.


    //내 풀이
    public int[] mySolution(int[] temperatures) {

        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length-1; i++) {
            int temperature = temperatures[i];
            int days = 0;

            for(int j = i+1; j < temperatures.length; j++) {
                if(temperature < temperatures[j]) {
                    result[i] = ++days;
                    break;
                } else {
                    days++;
                }
            }
        }

        result[temperatures.length-1] = 0;
        return result;
    }

    //이중 for문 풀이 O(n^2)
    public int[] solution(int[] temperatures) {

        int len = temperatures.length;
        int[] result = new int[len];
        int count=0, j;

        for(int i =0; i < len; i++){
            //며칠이 있는지 계산
            for(j = i+1; j < len-1; j++) { //다음 숫자와 비교
                if(temperatures[i] < temperatures[j]) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }

            //계산한 값을 결과에 넣기
            if(j == len) {
                result[i] = 0;
            } else {
                result[i] = count;
            }

            count = 0; //초기화
        }

        return result;
    }

    //[중요]Stack을 이용한 풀이
    //시간 복잡도 O(N), 최악의 경우O(n+n) :스택의 마지막 인덱스까지 계산하는 경우
    //공간 복잡도 O(N) :
    //릿코드를 사용해 속도를 비교해보니 나의 풀이(2100ms)보다 훨훨훨씬 빨랐다.(97ms)
    //현재 값과 그 다음 값들과 연산이 필요한 유형의 문제에서 stack을 활용해볼 수 있다.
    public int[] solutionUsingStack(int[] temperatures) {

        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
            //온도를 비교해 인덱스를 스텍에 저장했다가, 조건을 만족하면 인덱스를 빼서 날짜를 구한다.
        }
        return result;
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        //Expection : [1,1,4,2,1,1,0,0]

        //Call
        DailyTemperature dt = new DailyTemperature();
        int[] mySolution = dt.mySolution(temperatures);
        int[] solution = dt.solution(temperatures);
        int[] solutionUsingStack = dt.solutionUsingStack(temperatures);

        //Output
        System.out.println("[mySolution] Outputs ===> " + Arrays.toString(mySolution));
        System.out.println("[solution] Outputs ===> " +  Arrays.toString(solution));
        System.out.println("[solutionUsingStack] Outputs ===> " +  Arrays.toString(solutionUsingStack));
    }
}
