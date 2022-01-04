package programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class No86051 {

    /* 없는 숫자 더하기 */
    //배열을 차례대로 소팅한 후에 0부터 9의 숫자를 비교해서 더했다.
    public int mySolution(int[] numbers) {
        Arrays.sort(numbers);

        int answer = 0, number = 0;
        for(int i = 0; i < numbers.length; i++) {
            for(; number <= 9; number++) {
                if(numbers[i] == number) {
                    number++;
                    break;
                }
                answer += number;
            }
        }
        for(; number <= 9; number++) {
            answer += number;
        }
        return answer;
    }


    //다른 사람의 풀이1
    //0~9의 합에서 숫자를 빼는 방법이 있었구나...
    public int otherSolution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }


    //다른 사람의 풀이2
    //람다 함수로 간결하게 표현했다.
    public int solution(int[] numbers) {
        return IntStream.range(0, 10).filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num)).sum();
    }
}
