package leetCode.queueStack;

import leetCode.Template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

    /* BinaryTreeLevelOrderTraversal */
    // 각 바이너리 트리의 레벨에 담긴 숫자를 List<List<Integer>> 타입으로 리턴하라

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

    //풀이
    //이 문제는 bfs의 어머니 형태로 Queue를 이용해야한다.
    public List<List<Integer>> solution(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //queue에 Tree 낳기

        while (!queue.isEmpty()) { //queue가 빌 때까지 돌린다.
            int size = queue.size(); //
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(list);
        }

        return result;
    }

    //실행
    public static void main(String[] args) {

        //TestData
        //Tree 형태로 테스트 데이터를 저장한다.
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //Call
        BinaryTreeLevelOrderTraversal btl = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> solution = btl.solution(root);

        //Output
        System.out.println("[solution] Outputs ===> " + solution);
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
    */
}

//기본적으로 TreeNode 형태는 문제에서 제공해준다.
//이 클래스를 이용해 만들어야한다.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}
