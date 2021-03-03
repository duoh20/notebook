package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class No68644 {

	public static int[] solution(int[] numbers) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
            	list.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list2 = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++) {
            if(!list2.contains(list.get(i))) list2.add(list.get(i));
        }
        
        int[] answer = new int[list2.size()];
        for(int i = 0; i < list2.size(); i++) {
        	answer[i] = list2.get(i).intValue();
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
	
	/* 다른 사람의 풀이 */
	//나와 비슷하게 푼 사람
	//tmep를 두어서 for문에서 바로 중복 제거를 했다.
	public static int[] solution1(int[] numbers) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
            	int temp = numbers[i] + numbers[j];
            	if(!list.contains(temp))
            		list.add(temp);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
	
	/* 다른 사람의 풀이 */
	//나와 다르게 푼 사람
	//set이 데이터 중복이 안되는 점을 이용했다.
	public static int[] solution2(int[] numbers) {
		Set<Integer> set = new TreeSet<>();
		
		//TreeSet은 데이터 중복이 불가하며 add하면 정렬도 함께 한다.
		for(int i = 0; i < numbers.length; i++) {
			 for(int j = i+1; j < numbers.length; j++) {
				 set.add(numbers[i] + numbers[j]);
			 }
		}
		
		return set.stream().mapToInt(Integer::intValue).toArray();
		//Stream은 Java8에서 컬렉션마다 순회 방식이 다르게 구현된 것을 해결하기 위해 추가되었다.
		//stream()은 컬렉션을 순회하며 값을 읽기만할 뿐 바꾸지는 않는다.
		//mapToInt는 Integer를 int값으로 바꾸었다.
		//Integer::intvalue는 람다식 표현법으로 메서드 참조를 간단히 표현한 것이다.
		//Integer::intValue == Integer.intValue()
	}
	
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		System.out.println(Arrays.toString(solution2(numbers)));
	}
}
