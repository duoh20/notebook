package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class No42576 {

    /* 완주하지 못한 선수 */
    //시도1) ArrayList를 사용해서 참가자와 완주자 명단을 비교하고 제거하여 효율성 검사에서 실패하였다.
    //시도2) Arrays.sort()를 사용해 이름을 정렬하여 참가자와 완주자 명단을 비교하여 해결했다.
    public String mySolution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        while(i < completion.length) {
            if(!completion[i].equals(participant[i])) {
                break;
            }
            i++;
        }

        String answer = participant[i];
        return answer;
    }


    //다른 사람의 풀이
    //이 문제는 해시를 이용해 탐색해야하는 문제이다.
    //getOrDefault(Object key, V DefaultValue) 메소드 : key가 있으면 매칭된 값을 반환하고 그렇지 않으면 디폴트로 설정한 값(DefaultValue)을 반환한다.
    public String otherSolution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
