package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class No12935 {

	/* 제일 작은 수 제거하기 */
	public int[] solution(int[] arr) {
        int temp = arr[0];
        
        if(arr.length == 1) {
        	
        	int[] answer = new int[1];
        	answer[0] = -1;
            
        	return answer;
             
        } else {
            
        	for(int i : arr) {
                if(i < temp) temp = i;
            }
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : arr) {
                if(i != temp) list.add(i);
            }
            
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
	
	//다른 사람의 풀이
	 public int[] solution1(int[] arr) {
	      if (arr.length <= 1) return new int[]{ -1 }; //계산이 필요없으면 리턴문을 빠져나오도록 설계하자.
	      int min = Arrays.stream(arr).min().getAsInt(); //stream으로가장 작은 값을 가져온다.
	      return Arrays.stream(arr).filter(i -> i != min).toArray(); //stream filter를 이용해 최소 값을 제외한 것을 뽑아 배열로 만든다.
	 }
}
