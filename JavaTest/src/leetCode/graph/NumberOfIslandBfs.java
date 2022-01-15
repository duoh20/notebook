package leetCode.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslandBfs {

    /* 섬의 수(NumberOfIslandDfs) */
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

    /**** Java에서 bfs ***/
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
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] =='1') //에러 케이스를 걸러냄
                return;
            grid[i][j] = 'X'; //visited 표시하기 위함
            for (int[] dir : dirs) {
                merge(grid, i + dir[0], j + dir[1]);
            }
        }
    }
    /******************/



    //풀이
    //횟수가 방향을 전역 변수로 선언
    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; //

    public int solution(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        //1.배열 크기 생성
        m = grid.length; //row 갯수 초기화
        n = grid[0].length; //column 갯수 초기화

        //2. 맞는 조건 찾기
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);; //bfs로 해당 지역을 검사
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int x, int y) {
        //3.Queue 생성 및 셋팅
        grid[x][y] = 'X'; //방문 여부 저장: 보통 변수 visited에 true, false로 구분하는데 여기서는 방문한 지점을 X로 초기화했다.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y}); //현재 위치한 좌표를 queue에 담는다.

        while (!queue.isEmpty()) {
            int[] curr = queue.poll(); //queue에서 좌표를 끄집어 내서 사방으로 이동해본다.
            for(int[] dir : dirs) {
                int x1 = curr[0] + dir[0];// x좌표
                int y1 = curr[1] + dir[1];// y좌표

                if(x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == '1') {
                    grid[x1][y1] = 'X';
                    queue.offer(new int[] {x1, y1}); //이동했을 때 칸의 값이 1이면 queue에 넣는다.
                }

//                ** || OR 조건(dfs일 때 선호, 조건에 맞지 않는 것을 던지는 개념이므로)
                //방문 영역(visited 변수 또는 현재 컬럼을 x로 초기화)을 어떻게 표시할지는 문제 유형 또는 선호에 따름
//                화f(x1 < 0 || x1 >= m || y1 < 0 || y1 > n || visitied[x1][y1] == true || grid[x1][y1] == 'X');
//                    continue;
//                ** && AND 조건 (bfs일 때 선호, 조건에 맞으면 파고 들기 때문)
//                if(x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && visitied[x1][y1] != true && grid[x1][y1] == '1'));
//                { //... }
            }
        }

    }
    //주로 dfs에서 에러 체크 부분에 대한 값이나, 방문한 셀에 대한 조건을 꼬아서 낸다.

    //실행
    public static void main(String[] args) {
        //TestData
        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','1','1'}};

        //Output  2

        //Call
        NumberOfIslandBfs noi = new NumberOfIslandBfs();
        int solution = noi.solution(grid);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(M*N)
                     char[][] grid에 대한 이중 for문인데 m과 n의 길이가 다름 (dfs, bfs 류)

        공간복잡도
        대상(Source): 메모리 사용량은 O(min(m, n)) : 최악의 경우(=모든 숫자가 1일 때)를 고려함
                     대상이 Queue인데, 행에 있는 것을 다 담으면 m개개 인데 모든 것을 다 담지는 않으므로 min(m*n)이다.
                     모든 값을 다 담아야하는 최악의 경우 max(m*n)이다.
    */
}
