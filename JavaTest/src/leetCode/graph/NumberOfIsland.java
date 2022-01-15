package leetCode.graph;

import java.util.*;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIsland {

    /* 섬의 수(NumberOfIsland) */
    //m*n binary grid가 주어질 때, cell의 1은 땅이고 0은 물이다.
    //섬은 수직 또는 수평으로 인접하는 땅(1)을 연결하여 형성되며,
    //섬은 grid의 네 모서리가 모두 물로 둘러 쌓여있다고 가정할 수 있다.
    //섬의 갯수를 리턴하라.


    //그래프 탐색
    //하나의 정점으로 시작해 차례대로 모든 정점을 한 번씩 방문
    /*
        Queue - bsf(너비우선탐색, Breadth-First Search)
        루트(혹은 다른 임의 노드)에서 시작해 인접한 노드를 먼저 탐색 (다익스트라, 페이스북 1촌 찾기)
        두 노드 사이의 최단 경로 또는 임의의 경로를 찾고 싶을 때 사용
        어떤 노드를 방문했었는지 여부를 반드시 기록해야한다 그렇지 않으면 무한루프에 빠질 수 있다.
    */
    /*
        Stack - dsf(깊이우선탐색, Depth-First Search)
        루트(root)노드에서 시작해 다음 분기로 넘어가기 전 해당 분기를 완벽하게 탐색하는 방식
        모든 노드를 방문해야하는 경우 이 방식을 선택하고,
        특징으로 dsf는 bfs에 비해 간단하지만 검색 속도는 느리다.
    */
    /*
        언제 어떤 알고리즘?
        1. 그래프의 모든 정점 방문 시 : 둘 중 편한 것 사용
        2. 경로의 특징을 저장해야할 때 : dfs
        3. 최단거리 : bfs
        4. 검색 대상 그래프가 많이 클 때: dfs
        5. 검색 대상 규모가 크지 않고 검색 시작점부터 원하는 대상의 위차가 멀지 않을 때 : bfs
    */

    /**** Java에서 dfs ***/
    class Example {
        int m, n;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public void exampleDfs(char[][] grid) {
            //1. 방향 설정 및 이차원 배열사이즈
            m = grid.length;
            n = grid[0].length;

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') { //2.탐색할 부분으로 들어와서 맞는 조건을 찾는다.
                        count++;
                        merge(grid, i, j); //3.재귀를 이용한다.(stack 개념)
                    }
                }
            }
        }

        public void merge(char[][] grid, int i, int j) { //4.조건을 체크해서 큐에 넣는 부분
            if (i < 0 || i >= m || j < 0 || j > n || grid[i][j] =='1') //에러 케이스를 걸러냄
                return;
            grid[i][j] = 'X'; //visited 표시하기 위함
            for (int[] dir : dirs) {
                merge(grid, i + dir[0], j + dir[1]);
            }
        }
    }
    /****************/



    //풀이
    //횟수가 방향을 전역 변수로 선언
    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; //

    public int solution(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length; //row 갯수 초기화
        n = grid[0].length; //column 갯수 초기화

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);; //dfs 구현
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j) {
        //stack(재귀 이용)
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') //에러 체크
            return;
        grid[i][j] = 'X'; //방문한 셀은 방문한 것으로 표시
        for(int[] dir : dirs) { //네 가지 방향으로 움직여야하므로 for 문으로 네 방향 좌표 배열만큼 돌림
            dfs(grid, i+dir[0], j+dir[1]); //자신을 호출, 재귀
        }
    }
    //주로 dfs에서 에러 체크 부분에 대한 값이나, 방문한 셀에 대한 조건을 꼬아서 낸다.

    //실행
    public static void main(String[] args) {
        //TestData
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','1'}};
        //Call
        NumberOfIsland noi = new NumberOfIsland();
        int solution = noi.solution(grid);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(M*N)
                     char[][] grid에 대한 이중 for문 (m, n)

        공간복잡도
        대상(Source): 메모리 사용량은 O(M*N) : 최악의 경우(=모든 숫자가 1일 때)를 고려함
                     내부 stack 생성
    */
}
