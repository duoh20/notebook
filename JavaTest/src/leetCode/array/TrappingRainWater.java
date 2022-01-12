package leetCode.array;

import leetCode.Template;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    /* 빗물 잡기(TrappingRainWater) */

    //전략
    //물이 차는 영역 : 감싸는 벽의 값의 차이가 있어야하고 밑의 높이 만큼 빼야함
    //Math.min(left[i], right[i]) - height[i]

    //풀이
    public int solution(int[] height) {

        int result = 0;
        if(height == null || height.length <= 2) { //height가 2개 이하면 물이 고일 곳이 없으므로 0이 리턴되어야한다.
            return result;
        }

        //1.leftMax[]
        //왼쪽에서 시작했을 때 최대 높이를 max에 기록하며 배열에 저장한다.
        //오른쪽에서 시작했을 때도 마찬가지로 배열에 저장한다.
        //left와 right 중 작은 값을 선택하여 배열에 담는다.
        //작은 값과 height의 원소를 빼서 배열에 저장한 후 합계를 구한다.
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int max = height[0];
        left[0] = height[0];

        for(int i = 1; i < len; i++) {
            if(height[i] < max) {
                left[i] = max;
            } else {
                left[i] = height[i];
                max = height[i];
            }
        }

        //2.rightMax[]
        max = height[len-1];
        right[len-1] = height[len-1];

        for(int i = len-2; i >= 0; i--) {
            if(height[i] < max) {
                right[i] = max;
            } else {
                right[i] = height[i];
                max = height[i];
            }
        }

        //3.min() - height
        for(int i = 0; i <len; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }


    //풀이2
    //이중for문으로 연산
    public int solution2(int[] height) {
        int result = 0;
        int n = height.length;

        for(int i = 0; i < n; i++) {
            int maxLeft = 0, maxRight = 0;
            for(int j = i; j >= 0; j--)
                maxLeft = Math.max(maxLeft, height[j]);
            for(int j = i; j < n; j++)
                maxRight = Math.max(maxRight, height[j]);
            result += Math.min(maxLeft, maxRight) - height[i];
        }

        return result;
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //Output: 6

        //Call
        TrappingRainWater trw = new TrappingRainWater();
        int solution = trw.solution(height);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N), height[] 크기 n개 만큼 for문 실행

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
    */
}

