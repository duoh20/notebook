package leetCode.sortingSearching;

import java.util.*;

public class MeetingRoom1 {

    /* 미팅룸(MeetingRoom1) */
    //미팅 시간(intervals[i] = [start, end]) 배열이 주어졌을 때,
    //intervals 배열을 이용해 사람들이 모든 회의에 참석할 수 있는 지 boolean을 리턴하라.

    //전략
    //1. 자바 Arrays 소팅
    //2. 전미팅.end > 현재미팅.start, 2차원배열 사용, 첫번째 배열 빼서 두 번째부터 비교, end = intervals[0][1]

    //풀이
    public boolean solution(int[][] intervals) {

        if(intervals == null || intervals.length == 0)
            return true;

        //1.sort(오름차순)
        //binary search로 되어 있어 시간 복잡도는 logn으로 줄어듬
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //{start, end}라면 start의 오름차순으로 정렬됨

        //2.for
        int end = intervals[0][1]; //첫번째 원소의 end 값을 변수 end에 미리 셋팅해둠
        for(int i = 1; i < intervals.length; i++) { //2번째 원소부터 start 값과 이전 원소의 end 값을 비교
            if(intervals[i][0] < end) { //시작 시간이 end보다 크면 모든 미팅에 참여할 수 없기 때문에 false
                return false;
            }
            end = intervals[i][1]; //이번 미팅의 end 값으로 초기화
        }

        return true;
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[][] intervals = {{5,10},{16,20},{0,30}};

        //Call
        MeetingRoom1 mr = new MeetingRoom1();
        Object solution = mr.solution(intervals);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(NlogN)
                     sort하여 logN, for문 한번 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(1)
                     추가적인 공간 사용 안함
    */
}
