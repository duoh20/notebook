package programmers.level1;

import java.util.ArrayList;

public class No12906 {

	/** 두 정수 사이의 합  **/
	//배열에 정수 0부터 9까지 임의의 수가 주어질 때, 연속적으로 나타나는 수는 제거하여 배열에 담는 함수를 완성하라
	//단 원소 순서는 유지해야한다.
	//제한 조건 1) 배열 arr은 1,000,000이하의 자연수

	/* 나의 풀이 */
	public int[] solution(int[] arr) {
		
		ArrayList<Integer> tempList = new ArrayList<>();
		
		int before = arr[0] != 0 ? 0 : -1;
		
		for(int i : arr) {
			if(i != before) tempList.add(i);
			before = i;
		}
		
		int[] answer = new int[tempList.size()];
		int temp = 0;
		
		for(int i : tempList) {
			
			answer[temp++] = i;
		}
		
	    return answer;
	}
	
	
	/* 다른 사람의 풀이 */
    public int[] anotherSolution(int []arr) {
    	
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10; //0~9까지만 들어가니까 이 범위 숫자만 제외하고 초기화면 되는데...! 이걸 생각 못했다..
        
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }
        
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        
        return answer;
    }
    
    
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,2,3};
		System.out.println(new No12906().solution(arr));
	}
}
