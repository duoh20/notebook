package programmers.level1;

import java.util.ArrayList;

public class No42840 {
	
	/* 모의고사
	 * 1,2,3 학생의 찍는 방식은 아래와 같다. 답안(answers)을 담은 배열과 대조했을 때 가장 많은 갯수를 맞춘 학생을 출력하라
	 * 단, 동점일 때에 오름차순으로 정렬해서 출력한다.
	 * */
	public int[] solution(int[] answers) {
        
        int[] person1 = {1,2,3,4,5};
        int plength1 = person1.length;
        int[] person2 = {2,1,2,3,2,4,2,5};
        int plength2 = person2.length;
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int plength3 = person3.length;
        int answer1 = 0, answer2=0, answer3=0;
        
        for(int i = 0 ; i < answers.length; i++)  {
            if(person1[i%plength1] == answers[i])
               answer1++;
            if(person2[i%plength2] == answers[i])
                answer2++;
            if(person3[i%plength3] == answers[i])
                answer3++;
        }
        
        int max = Math.max(Math.max(answer1, answer2), answer3);
        ArrayList<Integer> tempResult = new ArrayList<>(); //<Integer>로 타입을 지정하지 않고 int[]에 get()으로 값을 집어넣으면, Objec를 집어넣을 수 없다는 참조 오류가 난다.
        if(max == answer1)
            tempResult.add(1);
        if(max == answer2)
            tempResult.add(2);
        if(max == answer3)
            tempResult.add(3);
        
        int[] result = new int[tempResult.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = tempResult.get(i);
        }
        
        return result;
    }

}
