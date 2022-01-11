package leetCode.sortingSearching;

import java.util.*;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosestPointsToOrigin {

    /* 원점에 가장 가까운 지점(KClosestPointsToOrigin) */
    //xy 평면의 한 점과 정수를 나타내는 배열(point)이 주어지면 원점에 가장 가까운 점을 반환한다.
    //xy 평면에서 두 점 사이의 거리를 구하는 공식이  √(x1 - x2)2 + (y1 - y2)2 일 때,
    //원점에서 제일 가까운 좌표를 k개의 갯수만큼 int[k][point]형식으로 리턴하라


    //풀이
    //PriorityQueue MinHeap을 이용한 풀이
    public int[][] solution1(int[][] points, int k) {

        //1.DataStructor
        //2차원 배열을 일차원으로 받아서 원소를 공식에 따라 계산한다.
        //
        Queue<int[]> pq = new PriorityQueue<>((a,b) ->
                (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])); //min-heap

        //결과값 저장하기 위한 배열 선언
        int[][] answer = new int[k][2];

        //for while
        for(int[] p : points) {
            pq.offer(p); //logn
        }

        int idx = 0;
        while(idx < k) { //logk
            answer[idx] = pq.poll();
            idx++;
        }

        return answer;
    }

    //PriorityQueue MaxHeap을 이용한 풀이
    public int[][] solution2(int[][] points, int k) {

        //1.DataStructor
        //2차원 배열을 일차원으로 받아서 원소를 공식에 따라 계산한다.
        Queue<int[]> pq = new PriorityQueue<>((b, a) ->
                (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])); //max-heap

        //결과값 저장하기 위한 배열 선언
        int[][] answer = new int[k][2];

        //for while
        //k개 까지만 담는다.
        for(int[] p : points) {
            pq.offer(p);
            if(pq.size() > k) { //logK
                pq.poll();
            }
        }

        int idx = 0;
        while(idx < k) { //logk
            answer[idx] = pq.poll();
            idx++;
        }

        return answer;
    }

    //실행
    public static void main(String[] args) {
        //TestData
        int[][] points = {{1,3}, {-2,-2}};
        int k = 1;

        //Call
        KClosestPointsToOrigin kcpto = new KClosestPointsToOrigin();
        int[][] solution1 = kcpto.solution1(points, k);
        int[][] solution2 = kcpto.solution2(points, k);

        //Output
        System.out.println("[solution1] Outputs ===> " + Arrays.deepToString(solution1));
        System.out.println("[solution2] Outputs ===> " + Arrays.deepToString(solution2));
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(NlogN)
                     for(int[] p : points)에서 전부 꺼내오고,
                     pq.offer(p)에 넣으므로 logN 만큼 이루어짐

        공간복잡도
        대상(Source): 메모리 사용량은 O(K)
                     answer에 point를 K개 만큼 넣고 있다.
    */
}
