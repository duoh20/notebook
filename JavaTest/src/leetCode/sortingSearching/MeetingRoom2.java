package leetCode.sortingSearching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

    /* 미팅룸(MeetingRoom2) */
    //미팅 시간(intervals[i] = [start, end]) 배열이 주어졌을 때,
    //intervals 사람들이 회의에 참석하려면 몇 개의 회의실이 필요한지 리턴하라

    //전략
    //회의 끝 시간이 제일 긴 것을 관리한다.
    //앞.end와 뒤.start를 비교한다.

    //풀이
    public int solution(int[][] intervals) {

        //1.sort(오름차순)
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); //{start, end}라면 start의 오름차순으로 정렬됨
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]); //end time 오름차순으로 관리

        //2.for
        for(int[] arr : intervals) {
            if(q.isEmpty()) {
                q.offer(arr);
            } else {
                if(q.peek()[1] <= arr[0]) {
                    q.poll();
                }
                q.offer(arr);
            }
        }
        return q.size();
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[][] intervals = {{5,10},{16,20},{0,30}};

        //Call
        MeetingRoom2 mr = new MeetingRoom2();
        int solution = mr.solution(intervals);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(NlogN)
                     sort하여 logN, for문 한번 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     pq에 대해 각 배열의 원소 수 만큼 추가 삭제가 일어남
    */
}
