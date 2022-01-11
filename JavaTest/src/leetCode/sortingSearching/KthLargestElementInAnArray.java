package leetCode.sortingSearching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {

    /* k번째 제일 큰 원소KthLargestElementInAnArray */
    //정수 배열 nums와 정수 k가 주어지면 배열에서 k번째로 큰 요소를 반환한다.
    //유일한 값 중 k번째로 가장 큰 값이 아니라 배열 순서에서 k번째로 큰 값을 찾아야한다.

    //내 풀이
    public int mySolution(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //풀이
    //Min Heap으로 풀기
    //priority queue(우선순위 큐)를 이용해서 사이즈 k를 유지하면 결국에 k개의 원소만 남게된다.
    public int solution(int[] nums, int k) {

        //Queue는 Interface이다.
        Queue<Integer> pq = new PriorityQueue<>(); //asc, minHeap(작은 값이 위로 올라감)_

        for(int i: nums) {
            pq.offer(i);
            if(pq.size() > k) {
                pq.poll(); //정렬하려는 것이 아니라 마지막 k개까지 남기는데 의의가 있으므로, 작은 값은 제거
            }
        }

        return pq.peek(); //맨 꼭대기에 있는 원소만 리턴
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int nums[] = {3,2,1,5,6,4};
        int k = 2;

        //Call
        KthLargestElementInAnArray kleiaa = new KthLargestElementInAnArray();
        Object mySolution = kleiaa.mySolution(nums, k);
        Object solution = kleiaa.solution(nums, k);

        //Output
        System.out.println("[mySolution] Outputs ===> " + mySolution);
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(Nlogk)
                     배열의 갯수만큼 n개 * 우선순위 큐 사용(logk)
                     PriorityQueue k개 만큼 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     PriorityQueue minHeap 최상단 k개 만큼만 교체
                     offer(), poll() 반복작업으로 항상 k개만큼 저장
    */
}
