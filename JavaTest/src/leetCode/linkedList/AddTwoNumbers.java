package leetCode.linkedList;

import java.util.List;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    /* 두 수 더하기(AddTwoNumbers) */
    //두 개의 비어있지 않고 양수가 담긴 linked list가 있다.
    //숫자는 역순이며 각 노드는 10 미만의 수를 담고 있다.
    //두 개의 linked list의 같은 인덱스의 노드를 더한 합계를 출력하라.
    //단 노드의 합계가 10 이상이면 10의 자리는 다음으로 넘긴다.
    // Inputs
    // 2 -> 4 -> 3
    // 5 -> 6 -> 2
    // 7    0    6
    // Output 706

    //List node의 Pointer를 어떻게 넘기는지 물어보는 문제

    //ListNode
    public ListNode solution(ListNode l1, ListNode l2) {
        //1 데이터 준비
        ListNode newHead = new ListNode(0);
        ListNode l3 = newHead;
        int carry = 0;

        //2
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val; //carry에 각 ListNode들의 같은 위치에 있는 노드 값들을 더함
                l1 = l1.next; //이전 노드를 버리고 다음 노드로 넘어감
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(carry % 10);
            l3.next = temp; //합이 2자리 이상이면 넘겨야함
            l3 = l3.next;
            carry /= 10; //carry에 몫을 다음으로 넘긴다.
        }

        if (carry == 1) l3.next = new ListNode(1); //마지막 노드를 거친 후 carry 합에 올림이 남아 있디면 마지막에 추가해준다.
        return newHead.next; //값을 담을 ListNode에 입력해두었던 첫번재 값을 제외하고 노드들의 합을 출력해준다.
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();

        //TestData
        AddTwoNumbers.ListNode l1 = atn.new ListNode(2);
        l1.next = atn.new ListNode(4);
        l1.next.next = atn.new ListNode(3);

        ListNode l2 = atn.new ListNode(5);
        l2.next = atn.new ListNode(6);
        l2.next.next = atn.new ListNode(2);

        // Output 706

        //Call
        ListNode solution = atn.solution(l1, l2);

        //Output
        while (solution != null) {
            System.out.println("[solution] Outputs ===> " + solution.val);
            solution = solution.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}