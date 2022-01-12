package leetCode.array;

import java.util.*;

//https://leetcode.com/problems/maximum-subarray/
public class MaxiumSubarray {

    /* 서브어레이 최대값(Maximum Subarray) */
    //정수 배열 nums가 주어지면 합계가 가장 큰 연속 하위 배열 (최소한 하나의 숫자 포함)을 찾아 합계를 리턴하라.
    //제약조건: 시간복잡도 O(n)으로 구하라.

    //풀이
    public int solution(int[] nums) {

        int curMax = nums[0];
        int allMax = nums[0];

        for(int i = 0; i < nums.length; i++) {
            curMax = Math.max(nums[i], nums[i] + curMax); //현재 포인터와 max를 초기화함
            allMax = Math.max(allMax, curMax); //가장 큰 max를 초기화함

        }
        return allMax;
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        //Expection : 6 ([4,-1,2,1]

        //Call
        MaxiumSubarray ms = new MaxiumSubarray();
        int solution = ms.solution(nums);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N), nums를 for문으로 돌림

        공간복잡도
        대상(Source): 메모리 사용량은 O(1), curMax, allMax를 상수로 사용, 다른 값 저장 안함
    */
}
