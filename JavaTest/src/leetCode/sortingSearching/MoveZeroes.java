package leetCode.sortingSearching;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {

    /* 제로 이동(MoveZeroes) */
    //정수 배열(nums)이 주어지면 0이 아닌 값은 상대적 순서를 유지하고
    //모든 0은 끝으로 이동하도록 만들어라.
    //단, 배열의 복사본을 만들지 않고 수행해야한다.

    //풀이1-1 : index 변수를 사용하여 뒤에 0 채우기
    public String solution1(int[] nums) {

        //0이 아닌 것을 앞부터 차례대로 넣음
        int n = nums.length; //index는 n - 1
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i]!=0) { //0이 아닌 것을 제외한다.
                nums[index] = nums[i];
                index++;
            }
        }

        //나머지 인덱스부터 배열의 끝까지 0을 채움
        while(index < n) {
            nums[index] = 0;
            index++;
        }

        return Arrays.toString(nums);
        //배열을 직접 toString()하면 주소값이 나온다. 배열 데이터를 String으로 바꾸려면 Arrays.toString()을 사용하자.
    }

    //풀이1-2 : index 변수를 사용하여 앞에 0 채우기
    public String solution1Reverse(int[] nums) {

        //0이 아닌 것을 뒤부터 차례대로 넣음
        int n = nums.length;
        int index = n-1; // 마지막 인덱스부터 실행하므로
        for(int i = index; i >= 0; i--) {
            if(nums[i]!=0) { //0이 아닌 것을 제외한다.
                nums[index] = nums[i];
                index--;
            }
        }

        //나머지 인덱스부터 배열의 끝까지 0을 채움
        while(index >= 0) {
            nums[index] = 0;
            index--;
        }

        return Arrays.toString(nums);
    }


    //실행
    public static void main(String[] args) {
        //TestData
        int[] nums = {0, 3, 2, 0, 8, 5};
        //int[] nums = = [0];

        //Call
        MoveZeroes mz = new MoveZeroes();
        String solution = mz.solution1(nums);
        String solutionReverse = mz.solution1Reverse(nums);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
        System.out.println("[solutionReverse] Outputs ===> " + solutionReverse);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)
                     nums만큼 for문 한 번 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(1)
                     추가적인 공간 사용 안함
    */
}
