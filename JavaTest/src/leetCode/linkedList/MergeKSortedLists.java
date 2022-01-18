package leetCode.linkedList;

import java.util.*;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {

    /* K개의 정렬된 리스트 병합(MergeKSortedLists) */
    //k개의 소팅된 LinkedList 배열 lists가 주어진다.
    //각각의 LinkedList는 오름차순으로 정렬되었다.
    //K개의 소팅된 lists를 하나의 정렬된 LinkedList로 병합하고 리턴하라.

    //내 풀이
    public ListNode solution(ListNode[] lists) {

        //Priority Queue를 정렬하는 다양한 방법
        //1)람다 표현식
        Queue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        //2)인라인
        Queue<ListNode> q2 = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val; //오름차순(min-Heap)
            }
        });
        //3)분리
        Queue<ListNode> q3 = new PriorityQueue<>(Comp);

        ListNode head = new ListNode(0);
        ListNode res = head;

        //Queue에 ListNode 넣기
        for(ListNode list : lists) {
            if(list != null) {
                queue.offer(list);
            }
        }

        while(!queue.isEmpty()) {
            ListNode node = queue.poll(); //가장 작은 수가 node에 담김
            res.next = node; //뽑아온 node를 ListNode를 뽑아 넣음
            res = res.next; //결과를 담은 ListNode의 포인터를 다음 노드로 옮겨둠

            if(node.next != null) {//poll하여 노드가 빠진 부분을 다음 노드를 채워 넣음
                queue.offer(node.next);
            }
        }

        return head.next; //res의 첫번째 ListNode에 담긴 0은 더미 데이터이므로 이것을 제외하고 돌려줌
    }

    Comparator<ListNode> Comp = new Comparator<>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };


    //실행
    public static void main(String[] args) {
        MergeKSortedLists msl = new MergeKSortedLists();

        //TestData
        ListNode list1 =  msl.new ListNode(1), list2 = msl.new ListNode(1), list3 = msl.new ListNode(2);
        list1.next = msl.new ListNode(4);
        list1.next = msl.new ListNode(5);
        list2.next = msl.new ListNode(3);
        list2.next = msl.new ListNode(4);
        list3.next = msl.new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        //Call
        ListNode solution = msl.solution(lists);

        //Output
        while(solution != null) {
            System.out.println("[solution] Outputs ===> " + solution.val);
            solution = solution.next;
        }
    }


    /*** 시간 복잡도와 공간 복잡도 계산 ***/
    /*
        시간복잡도
        대상(Source): 시간 복잡도는 O(N)

        공간복잡도
        대상(Source): 메모리 사용량은 O(N)
    */

    /**
     * Definition for singly-linked list.
     * */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


