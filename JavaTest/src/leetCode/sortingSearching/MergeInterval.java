package leetCode.sortingSearching;

import java.util.*;

public class MergeInterval {

    /* interval 병합(MergeInterval) */
    //intervals 배열이 주어지면 겹치는 구간을 병합해 배열을 반환히라


    //풀이
    public int[][] solution(int[][] intervals) {

        List<int[]> answer = new ArrayList<>();

        //1.DataStructure
        Arrays.sort(intervals, (a,b) -> a[0] -  b[0]); //오름차순

        //2.for
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(end >=  intervals[i][0]) {
                end = Math.max(end, intervals[i][1]); //end의 값을 더 큰 값으로 초기화
            } else {
                answer.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        answer.add(new int[]{start,end}); //마지막 원소를 한번 더 담아줌

        //List<int[]> 타입의 1차원 배열 리스트를 2차원 배열로 바꿔준다.
        //2차원 배열 <-> List 변환 빈출, 숙지하자!!
        return answer.toArray(new int[answer.size()][]);
        //return answer.toArray(new int[0][]); //이것도 가능
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[][] intervals = {{1,4},{2,6},{8,10},{15,18}}; //[1,4][2,6]이 겹치므로 [1,6]으로 병합

        //Call
        MergeInterval mi = new MergeInterval();
        int[][] solution = mi.solution(intervals);

        //Output
        System.out.println("[solution] Outputs ===> " + Arrays.deepToString(solution));
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(NlogN)
                     소팅 사용 logN, intervals 원소 갯수(N)만큼 for문 한 번 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(logN) 또는 O(N)
                     intervals 자체를 이용하면 O(1)으로 볼 수 있고,
                     결과를 담은 arrayList에 모든 원소 복사해오면 O(N), 겹치는 원소가 많아 하나로 병합된다면 O(logN)
    */
}
