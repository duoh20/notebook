package leetCode.sortingSearching;

import java.util.*;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    /* 두 개 합(TwoSum) */
    //정수 배열 nums와 정수 target이 주어질 때,
    //배열 nums에서 두 숫자의 값을 더해 target값과 동일할 경우 두 숫자의 인덱스를 리턴한다.
    //제약조건: 시간 복잡도 O(n)으로 수해야한다. (== 이중 for문 쓸 수 없음)


    //O(n^2) : 제약 조건을 고려하지 않은 풀이
    public int[] solution1(int[] nums, int target) {

        int len = nums.length;

        for(int i = 0 ; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i+1, j+1}; //1베이스 인덱스를 원하기 때문에 +1
                }
            }
        }

        return new int[] {0,0}; //null 체크
    }

    //O(n) : Map을 활용한 풀이
    public int[] solution2(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]) + 1;
                result[1] = i + 1;
            } else {
                map.put(target - nums[i], i); //tartget - nums[i]한 값을 키로 추가하고, 다음 요소에 나머지 값들이 존재하는지 확인한다.
            }
        }

        return result; //null 체크
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[] nums = {2, 8, 11, 14};
        int target = 16;

        //Expection [1,4]

        //Call
        TwoSum ts = new TwoSum();
        int[] solution1 = ts.solution1(nums, target);
        int[] solution2 = ts.solution2(nums, target);

        //Output
        System.out.println("[solution1] Outputs ===> " + Arrays.toString(solution1));
        System.out.println("[solution2] Outputs ===> " +  Arrays.toString(solution2));
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)
                     for문 한 번 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
                     for문 실행하면서 map.put
    */
}
